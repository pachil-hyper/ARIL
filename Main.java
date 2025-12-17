package com.pertemuan9.mix;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowSwingUI);
    }

    private static void createAndShowSwingUI() {
        JFrame frame = new JFrame("Hybrid UI: Swing + JavaFX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Label ini dari Swing", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel, BorderLayout.CENTER);

        JButton swingButton = new JButton("Klik Swing");
        frame.add(swingButton, BorderLayout.SOUTH);

        swingButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Klik dari Swing!")
        );

        
        Platform.runLater(() -> {
            Button fxButton = new Button("Tombol dari JavaFX");
            fxButton.setOnAction(e -> System.out.println("Klik dari JavaFX!"));

            StackPane root = new StackPane(fxButton);
            fxPanel.setScene(new Scene(root, 300, 200));
        });

        frame.setVisible(true);
    }
}
