/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication50;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mayam
 */
public class LibraryManagementSystemGUI implements ActionListener {
    private JFrame frame;
    private JTable table;
    private JTextField isbnField, titleField, authorField, publisherField, yearField;
    private DefaultTableModel model;
    private ArrayList<Book> books = new ArrayList<>();

    public LibraryManagementSystemGUI() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create table
        String[] columns = {"ISBN", "Title", "Author", "Publisher", "Year"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create input fields
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnField = new JTextField(20);
        JPanel isbnPanel = new JPanel();
        isbnPanel.setLayout(new BoxLayout(isbnPanel, BoxLayout.X_AXIS));
        isbnPanel.add(isbnLabel);
        isbnPanel.add(Box.createHorizontalStrut(10));
        isbnPanel.add(isbnField);

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.add(titleLabel);
        titlePanel.add(Box.createHorizontalStrut(10));
        titlePanel.add(titleField);

        JLabel authorLabel = new JLabel("Author(s):");
        authorField = new JTextField(20);
        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.X_AXIS));
        authorPanel.add(authorLabel);
        authorPanel.add(Box.createHorizontalStrut(10));
        authorPanel.add(authorField);

        JLabel publisherLabel = new JLabel("Publisher:");
        publisherField = new JTextField(20);
        JPanel publisherPanel = new JPanel();
        publisherPanel.setLayout(new BoxLayout(publisherPanel, BoxLayout.X_AXIS));
        publisherPanel.add(publisherLabel);
        publisherPanel.add(Box.createHorizontalStrut(10));
        publisherPanel.add(publisherField);

        JLabel yearLabel = new JLabel("Year:");
        yearField = new JTextField(20);
        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.X_AXIS));
        yearPanel.add(yearLabel);
        yearPanel.add(Box.createHorizontalStrut(10));
        yearPanel.add(yearField);

        // Create buttons
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(this);

        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(this);

        // Add components to frame
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(isbnPanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(titlePanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(authorPanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(publisherPanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(yearPanel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(addButton);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(removeButton);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(inputPanel, BorderLayout.WEST);

        // Show frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Book")) {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String publisher = publisherField.getText();
            int year = Integer.parseInt(yearField.getText());
            
            if (isISBNUnique(isbn)) {
                Book book = new Book(isbn, title, author, publisher, year);
                books.add(book);
                Object[] row = {isbn, title, author, publisher, year};
                model.addRow(row);
                JOptionPane.showMessageDialog(frame, "Book added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book with this ISBN already exists in the inventory!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals("Remove Book")) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String isbn = (String) model.getValueAt(selectedRow, 0);
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getISBN().equals(isbn)) {
                        books.remove(i);
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(frame, "Book removed successfully!");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to remove!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        public boolean isISBNUnique(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return false;
            }
        }
        return true;
    }
    }

