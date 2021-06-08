package texteditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;

public class TextEditor extends JFrame implements ActionListener {
	
	private static final KeyEvent VK_ENTER = null;

	// for copy, paste
	String text;
		
	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel fontLabel;
	JSpinner fontSizeSpinner;
	JButton fontColourButton;
	JComboBox fontBox;
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newItem;
	JMenuItem openItem;
	JMenuItem saveAsItem;
	JMenuItem saveItem;
	JMenuItem printItem;
	JMenuItem exitItem;
	private File openFile;
	
	UndoManager um = new UndoManager();
	
	TextEditor(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the window 
		this.setTitle("Sample Text Editor");
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);//display window in the relative centre
		
		textArea= new JTextArea();
		
		textArea.setLineWrap(true);//to continue on next line
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial",Font.PLAIN,20));
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener()
				{
					public void undoableEditHappened(UndoableEditEvent e)
					{
						um.addEdit(e.getEdit());
					}
				}
				);
		
		scrollPane=new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		fontLabel=new JLabel("Font Size: ");
		
		fontSizeSpinner= new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN, (int) fontSizeSpinner.getValue()));
				
			}
		});
		
		fontColourButton= new JButton("Font Colour");
		fontColourButton.addActionListener(this);
		
		String[] fonts= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox=new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");
		
		menuBar=new JMenuBar();
		
		//menu bar operations
		
		fileMenu=new JMenu("File");
		
		newItem = new JMenuItem("New");
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newItem.addActionListener(this);
		
		openItem=new JMenuItem("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		openItem.addActionListener(this);
		
		saveAsItem=new JMenuItem("Save As...");
		saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, ActionEvent.CTRL_MASK));
		saveAsItem.addActionListener(this);
		
		saveItem=new JMenuItem("Save");
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveItem.addActionListener(this);
		
		printItem=new JMenuItem("Print");
		printItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		printItem.addActionListener(this);
		
		exitItem=new JMenuItem("Exit");
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(this);
		
		fileMenu.add(openItem);
		fileMenu.add(newItem);
		fileMenu.add(printItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		
		//menu bar edit operations
		JMenu edit = new JMenu("Edit");
		
		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		copyItem.addActionListener(this);
		
		JMenuItem pasteItem = new JMenuItem("Paste");
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		pasteItem.addActionListener(this);
		
		JMenuItem cutItem = new JMenuItem("Cut");
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		cutItem.addActionListener(this);
		
		JMenuItem selectAllItem = new JMenuItem("Select All");
		selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		selectAllItem.addActionListener(this);
		
		JMenuItem findItem=new JMenuItem("Find");
		findItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		findItem.addActionListener(this);
		
		JMenuItem replaceItem=new JMenuItem("Replace All");
		replaceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		replaceItem.addActionListener(this);
		
		JMenuItem undoItem = new JMenuItem("Undo");
		undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		undoItem.addActionListener(this);
		
		JMenuItem redoItem = new JMenuItem("Redo");
		redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		redoItem.addActionListener(this);
		
		JMenuItem wordCount = new JMenuItem("Word Count");
		wordCount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		wordCount.addActionListener(this);
		
		JMenuItem characterCount = new JMenuItem("Character Count");
		characterCount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		characterCount.addActionListener(this);
		
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.add(cutItem);
		edit.add(selectAllItem);
		edit.add(findItem);
		edit.add(replaceItem);
		edit.add(undoItem);
		edit.add(redoItem);
		edit.add(wordCount);
		edit.add(characterCount);
		
		// help
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(this);
		
		help.add(about);
		
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(edit);		
		menuBar.add(help);
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(fontColourButton);
		this.add(fontBox);
		this.add(scrollPane);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fontColourButton)
		{
			JColorChooser colourChooser= new JColorChooser();
			Color colour=colourChooser.showDialog(null, "Font Colour", Color.black);
			textArea.setForeground(colour);
		}
		
		if(e.getSource()==fontBox)
		{
			textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
		}
		if(e.getSource()==openItem)
		{
			try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Select a text file to open");
			fileChooser.showOpenDialog(null);
			openFile= fileChooser.getSelectedFile();
			if(openFile!=null && !openFile.exists())
			{
				JOptionPane.showMessageDialog(null,"Failed to open file.File does not exist!","Error",JOptionPane.ERROR_MESSAGE);
				openFile=null;
				return;
			}
			
			Scanner reader=new Scanner(openFile);
			String contents="";
			while(reader.hasNextLine()) {
				contents+=reader.nextLine()+"\n";
			}
			reader.close();
			textArea.setText(contents);
			this.setTitle(getTitle()+" - "+openFile.getName());
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		}
		
		if(e.getSource()==saveAsItem)
		{
			try
			{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Save new File");
			fileChooser.showSaveDialog(null);
			
			openFile=fileChooser.getSelectedFile();
			save();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==saveItem)
		{
			save();
		}
		if(e.getSource()==exitItem)
		{
			if(openFile==null)
			{
				JOptionPane.showMessageDialog(null,"Failed to close file.File does not exist!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				int input=JOptionPane.showConfirmDialog(null,"Do you want to save before closing?","Wait!",JOptionPane.YES_NO_OPTION );
				if(input==JOptionPane.YES_OPTION)
				{
					save();
				}
				textArea.setText("");
				openFile=null;
				this.setTitle(getTitle());
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getActionCommand().equals("New")){
			textArea.setText("");
		}
		if(e.getActionCommand().contentEquals("Print")) {
			try {
				textArea.print();
			}catch(Exception ae) {}
		}
		if(e.getActionCommand().equals("Copy"))
		{
			text = textArea.getSelectedText();
		}
		if(e.getActionCommand().equals("Paste"))
		{
			textArea.insert(text, textArea.getCaretPosition());
		}
		if(e.getActionCommand().equals("Cut"))
		{
			text = textArea.getSelectedText();
			textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
		}
		if(e.getActionCommand().equals("Select All"))
		{
			textArea.requestFocus();
			textArea.selectAll();
		}
		if(e.getActionCommand().equals("Find"))
		{
			String s1=JOptionPane.showInputDialog("Enter String to Find");
			highlight(textArea,s1);
			int input=JOptionPane.showConfirmDialog(null,"Do you want to remove highlight?","Wait!",JOptionPane.YES_NO_OPTION );
			if(input==JOptionPane.YES_OPTION)
			{
				removeHighlight(textArea);
			}
		}
		if(e.getActionCommand().equals("Replace All"))
		{
			String s1=JOptionPane.showInputDialog("Enter String to Find");
			highlight(textArea,s1);
			String s2=JOptionPane.showInputDialog("Replace With: ");
			replaceString(textArea,s1,s2);
		}
		if(e.getActionCommand().equals("Undo"))
		{
			if(um.canUndo()==true)
			{
				um.undo();
			}	
		}
		if(e.getActionCommand().equals("Redo"))
		{
			if(um.canRedo()==true)
			{
				um.redo();
			}
		}
		if(e.getActionCommand().equals("About"))
		{
			JOptionPane.showMessageDialog(null, "This project implements a text editor with functionalities such as save, new, print, open, etc. in the File menu and undo, redo, copy, paste, find and replace, word count, etc. in the edit menu. \r\n"
					+ "Programming language used: Java\r\n"
					+ "Implemented using: Java Swing (for UI) and File Handling\r\n"
					+ "Data Structures used: Array of objects, String data type implemented as array, Stack for undomanager \r\n");
			
		}
		if(e.getActionCommand().equals("Word Count"))
		{
			 int wc=countWords(textArea.getText());
			 JOptionPane.showMessageDialog(null, "Number of words= "+wc);
		       
		}
		if(e.getActionCommand().equals("Character Count"))
		{
			 int count=countCharacters(textArea.getText());
			 JOptionPane.showMessageDialog(null, "Number of characters= "+count);
		       
		}
		
	}
	private void save()
	{
		try {
			if(openFile==null)
			{
				JOptionPane.showMessageDialog(null,"Failed to save file.File does not exist!","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			String contents=textArea.getText();
			Formatter form=new Formatter(openFile);
			form.format("%s",contents);
			form.close();
			
			this.setTitle(getTitle()+" - "+openFile.getName());
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	Highlighter.HighlightPainter myHighlightPainter= new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	
	private void removeHighlight(JTextComponent textComp)
	{
		Highlighter highlight1=textComp.getHighlighter();
		Highlighter.Highlight[] highlightes= highlight1.getHighlights();
		
		for(int i=0; i<highlightes.length;i++)
		{
			if(highlightes[i].getPainter() instanceof DefaultHighlightPainter)
			{
				highlight1.removeHighlight(highlightes[i]);
			}
		}
	}
	
	private void highlight(JTextComponent textComp,String pattern)
	{
		removeHighlight(textComp);
		try {
			Highlighter highlight1=textComp.getHighlighter();
			Document doc=textComp.getDocument();
			String text=doc.getText(0, doc.getLength());
			int pos=0;
			
			while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0) {
				highlight1.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
				pos+=pattern.length();
				
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	private void replaceString(JTextComponent textComp, String s1,String s2)
	{
        removeHighlight(textComp);
        int start=0;
        int pos=0;
        try {
        	 Document doc=textComp.getDocument();
     		String text=doc.getText(0, doc.getLength());
             while((pos=text.toUpperCase().indexOf(s1.toUpperCase(),pos))>=0)
             {
             	start = textArea.getText().indexOf(s1);
                 if (start >= 0 && s1.length() > 0)
                   textArea.replaceRange(s2, start, start
                       + s1.length());
                 pos+=s1.length();
             }
        }catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	static final int OUT = 0;
    static final int IN = 1;
	private int countWords(String str)
	{
		 int state = OUT;
	     int wc = 0;  // word count
         int i = 0;
         while (i < str.length())
         {
             if (str.charAt(i) == ' ' || str.charAt(i) == '\n'|| str.charAt(i) == '\t')
             {
            	 state = OUT;
             }
             else if (state == OUT)
             {
                 state = IN;
                 ++wc;
             }
             ++i;
         }
         return wc;
	}
	private int countCharacters(String str)
	{
		  int count = 0;    
          
	        //Counts each character except space    
	        for(int i = 0; i < str.length(); i++) {    
	            if(str.charAt(i) != ' ')    
	                count++;    
	        }
	            
	         return count;
	}
	
}

