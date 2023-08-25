import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.*;

class UniqueWordCounterApp extends JFrame {
    private JTextArea inputTextArea;
    private JTextField delimiterField;
    private JTextArea outputTextArea;
    private JButton analyzeButton;

    public UniqueWordCounterApp() {
        setTitle("Unique Word Counter App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea(8, 40);
        delimiterField = new JTextField(15);
        outputTextArea = new JTextArea(15, 40);
        analyzeButton = new JButton("Analyze");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Enter text:"));
        inputPanel.add(new JScrollPane(inputTextArea));
        inputPanel.add(new JLabel("Enter delimiter:"));
        inputPanel.add(delimiterField);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputTextArea), BorderLayout.CENTER);
        add(analyzeButton, BorderLayout.SOUTH);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAnalysis();
            }
        });
    }

    private void performAnalysis() {
        String inputText = inputTextArea.getText();
        String delimiter = delimiterField.getText();

        if (inputText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide valid text.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] words = inputText.split(delimiter);
        outputTextArea.setText("");

        LinkedHashMap<String, Integer> wordFrequencyMap = new LinkedHashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        outputTextArea.append("Total word count: " + words.length + "\n");
        outputTextArea.append("Number of unique words: " + wordFrequencyMap.size() + "\n\n");
        outputTextArea.append("Word frequencies:\n\n");

        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            outputTextArea.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UniqueWordCounterApp app = new UniqueWordCounterApp();
                app.setVisible(true);
            }
        });
    }
}
