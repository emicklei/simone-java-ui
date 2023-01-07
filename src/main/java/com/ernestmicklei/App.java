package com.ernestmicklei;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class App {

    public static void main(String[] args) {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout(3, 3));
        main.setPreferredSize(new Dimension(433, 312));
        JTextPane textPane = null;/* w  w  w  .  j a v a 2  s  .  com*/

        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5, 5, 5, 5));

        main.add(textPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu fontsMenu = new JMenu("Fonts");

        ButtonGroup fontGroup = new ButtonGroup();
        JRadioButtonMenuItem serifItem = new JRadioButtonMenuItem("Serif");
        serifItem.setAction(new StyledEditorKit.FontFamilyAction(Font.SERIF, Font.SERIF));
        fontsMenu.add(serifItem);
        fontGroup.add(serifItem);

        JRadioButtonMenuItem sansSerifItem = new JRadioButtonMenuItem("SansSerif", null);
        sansSerifItem.setSelected(true);
        sansSerifItem.setAction(new StyledEditorKit.FontFamilyAction(Font.SANS_SERIF, Font.SANS_SERIF));
        fontsMenu.add(sansSerifItem);
        fontGroup.add(sansSerifItem);

        JRadioButtonMenuItem monoItem = new JRadioButtonMenuItem("MONO SPACED", null);
        monoItem.setAction(new StyledEditorKit.FontFamilyAction(Font.MONOSPACED, Font.MONOSPACED));
        fontsMenu.add(monoItem);
        fontGroup.add(monoItem);

        menuBar.add(fontsMenu);

        JMenu sizeMenu = new JMenu("Size");

        ButtonGroup sizeGroup = new ButtonGroup();
        JRadioButtonMenuItem size12Item = new JRadioButtonMenuItem("12");
        size12Item.setSelected(true);
        size12Item.setAction(new StyledEditorKit.FontSizeAction("12", 12));
        sizeMenu.add(size12Item);
        sizeGroup.add(size12Item);

        JRadioButtonMenuItem size14Item = new JRadioButtonMenuItem("14");
        size14Item.setAction(new StyledEditorKit.FontSizeAction("14", 14));
        sizeMenu.add(size14Item);
        sizeGroup.add(size14Item);

        JRadioButtonMenuItem size16Item = new JRadioButtonMenuItem("16");
        size16Item.setAction(new StyledEditorKit.FontSizeAction("16", 16));
        sizeMenu.add(size16Item);
        sizeGroup.add(size16Item);

        JRadioButtonMenuItem size18Item = new JRadioButtonMenuItem("18");
        size18Item.setAction(new StyledEditorKit.FontSizeAction("18", 18));
        sizeMenu.add(size18Item);
        sizeGroup.add(size18Item);

        menuBar.add(sizeMenu);

        JMenu styleMenu = new JMenu("Style");

        JCheckBoxMenuItem boldItem = new JCheckBoxMenuItem("Bold", null);
        styleMenu.add(boldItem);
        boldItem.setAction(new StyledEditorKit.BoldAction());

        JCheckBoxMenuItem italicItem = new JCheckBoxMenuItem("Italic", null);
        italicItem.setAction(new StyledEditorKit.ItalicAction());
        styleMenu.add(italicItem);

        menuBar.add(styleMenu);

        JFrame frame = new JFrame("java2s.com");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(main);

        frame.setJMenuBar(menuBar);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}