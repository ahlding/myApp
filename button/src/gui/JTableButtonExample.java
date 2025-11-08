package gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class JTableButtonExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTable Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Table data
            Object[][] data = {
                    {"Row 1", "Click Me"},
                    {"Row 2", "Click Me"},
                    {"Row 3", "Click Me"}
            };

            // Table column names
            String[] columnNames = {"Name", "Action"};

            // Create table model
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Create JTable
            JTable table = new JTable(model);

            // Add button renderer and editor
            table.getColumn("Action").setCellRenderer(new ButtonRenderer());
            table.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));

            // Add table to frame
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// Custom Button Renderer
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value == null ? "" : value.toString());
        return this;
    }
}

// Custom Button Editor
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean clicked;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);

        // Add button click listener
        button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = value == null ? "" : value.toString();
        button.setText(label);
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            JOptionPane.showMessageDialog(button, "Button clicked in row " + label);
        }
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}
