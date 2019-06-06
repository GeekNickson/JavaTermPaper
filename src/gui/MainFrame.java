package gui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class MainFrame extends JFrame {
	private JLabel usernameLabel;
	private JLabel ipLabel;
	private JLabel portLabel;
	private JLabel passwordLabel;
	private JLabel nameScoreLabel;
	private JLabel showUsernameLabel;
	private JLabel greetingsLabel;
	private JLabel scoreLabel;
	private JLabel selectedLevelLabel;
	private JLabel currentScoreLabel;
	private JLabel currentLevelLabel;
	private JLabel selectLevelLabel;
	private JTextField usernameTextField;
	private JTextField ipAddressTextField;
	private JTextField portTextField;
	private JTextField passwordTextField;
	private JButton connectButton;
	private JButton disconnectButton;
	private JButton registerButton;
	private JButton playButton;
	private JButton levelOneButton;
	private JButton levelFiveButton;
	private JButton levelTenButton;
	private JButton levelFifteenButton;
	private JButton levelTwentyButton;
	private JButton levelTwentyFiveButton;
	private JButton surrenderButton;
	private JTable scoreboardTable;
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	private Font levelFont = new Font("Showcard Gothic", Font.PLAIN, 24);
	private Font levelTextFont = new Font("Showcard Gothic", Font.PLAIN, 14);
	private TetrisGrid tetrisGrid;
	private int rows = 21;
	private int columns = 10;
	private int chosenLevel;

	public MainFrame() {
		// TODO follow singleton design pattern
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 30, 130, 30);
		usernameLabel.setFont(mainFont);
		add(usernameLabel);
		usernameTextField = new JTextField("enter your name");
		usernameTextField.setBounds(200, 30, 200, 30);
		add(usernameTextField);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 100, 130, 30);
		passwordLabel.setFont(mainFont);
		add(passwordLabel);
		passwordTextField = new JTextField("enter your password");
		passwordTextField.setBounds(200, 100, 200, 30);
		add(passwordTextField);
		ipLabel = new JLabel("Ip address:");
		ipLabel.setBounds(50, 170, 130, 30);
		ipLabel.setFont(mainFont);
		add(ipLabel);
		ipAddressTextField = new JTextField("enter server's ip");
		ipAddressTextField.setBounds(200, 170, 200, 30);
		add(ipAddressTextField);
		portLabel = new JLabel("Used port:");
		portLabel.setBounds(50, 240, 130, 30);
		portLabel.setFont(mainFont);
		add(portLabel);
		portTextField = new JTextField("5050");
		portTextField.setBounds(200, 240, 200, 30);
		add(portTextField);
		connectButton = new JButton("Connect");
		connectButton.setBounds(30, 310, 200, 30);
		connectButton.setFont(mainFont);
		connectButton.setBackground(new Color(247, 170, 232));
		add(connectButton);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setBounds(255, 310, 200, 30);
		disconnectButton.setFont(mainFont);
		disconnectButton.setBackground(new Color(247, 170, 232));
		disconnectButton.setEnabled(false);
		add(disconnectButton);
		registerButton = new JButton("Register");
		registerButton.setBounds(150, 380, 200, 30);
		registerButton.setFont(mainFont);
		registerButton.setBackground(new Color(247, 170, 232));
		add(registerButton);
		// Game menu
		usernameLabel = new JLabel("");
		usernameLabel.setFont(mainFont);
		greetingsLabel = new JLabel("Welcome back,");
		greetingsLabel.setFont(mainFont);
		greetingsLabel.setVisible(false);
		greetingsLabel.setBounds(1200, 240, 200, 30);
		add(greetingsLabel);
		playButton = new JButton("Play");
		playButton.setBounds(1200, 300, 300, 30);
		playButton.setFont(mainFont);
		playButton.setBackground(new Color(247, 170, 232));
		add(playButton);
		selectLevelLabel = new JLabel("Level");
		selectLevelLabel.setFont(levelFont);
		selectLevelLabel.setBounds(1320, 350, 200, 30);
		add(selectLevelLabel);
		levelOneButton = new JButton("1");
		levelOneButton.setBounds(1200, 390, 50, 30);
		levelOneButton.setBackground(new Color(231, 0, 0));
		levelOneButton.setFont(levelTextFont);
		levelOneButton.setForeground(new Color(255, 255, 255));
		add(levelOneButton);
		levelFiveButton = new JButton("5");
		levelFiveButton.setBounds(1250, 390, 50, 30);
		levelFiveButton.setBackground(new Color(255, 140, 0));
		levelFiveButton.setFont(levelTextFont);
		levelFiveButton.setForeground(new Color(255, 255, 255));
		add(levelFiveButton);
		levelTenButton = new JButton("10");
		levelTenButton.setBounds(1300, 390, 50, 30);
		levelTenButton.setBackground(new Color(255, 239, 0));
		levelTenButton.setFont(levelTextFont);
		levelTenButton.setForeground(new Color(255, 255, 255));
		add(levelTenButton);
		levelFifteenButton = new JButton("15");
		levelFifteenButton.setBounds(1350, 390, 50, 30);
		levelFifteenButton.setBackground(new Color(0, 129, 31));
		levelFifteenButton.setFont(levelTextFont);
		levelFifteenButton.setForeground(new Color(255, 255, 255));
		add(levelFifteenButton);
		levelTwentyButton = new JButton("20");
		levelTwentyButton.setBounds(1400, 390, 50, 30);
		levelTwentyButton.setBackground(new Color(0, 68, 255));
		levelTwentyButton.setFont(levelTextFont);
		levelTwentyButton.setForeground(new Color(255, 255, 255));
		add(levelTwentyButton);
		levelTwentyFiveButton = new JButton("25");
		levelTwentyFiveButton.setBounds(1450, 390, 50, 30);
		levelTwentyFiveButton.setBackground(new Color(118, 0, 137));
		levelTwentyFiveButton.setFont(levelTextFont);
		levelTwentyFiveButton.setForeground(new Color(255, 255, 255));
		add(levelTwentyFiveButton);
		nameScoreLabel = new JLabel("       Name           Score");
		nameScoreLabel.setFont(mainFont);
		nameScoreLabel.setBounds(1200, 470, 300, 30);
		add(nameScoreLabel);
		scoreboardTable = new JTable(5, 2) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				JComponent jc = (JComponent) super.prepareRenderer(renderer, row, column);
				jc.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
				return jc;
			}
		};
		scoreboardTable.setDefaultEditor(Object.class, null);
		;
		scoreboardTable.setBounds(1200, 500, 300, 200);
		scoreboardTable.setBackground(new Color(240, 240, 240));
		scoreboardTable.setSelectionBackground(new Color(240, 240, 240));
		scoreboardTable.setOpaque(true);
		// scoreboardTable.setBorder(border);
		scoreboardTable.setRowHeight(40);
		add(scoreboardTable);
		// Game
		tetrisGrid = new TetrisGrid(rows, columns);
		tetrisGrid.setVisible(false);
		tetrisGrid.setBounds(1200, 35, columns * 25 + 5, rows * 25 + 5);
		this.repaint();
		add(tetrisGrid);
		scoreLabel = new JLabel("Score");
		scoreLabel.setBounds(1500, 35, 100, 20);
		scoreLabel.setFont(mainFont);
		scoreLabel.setVisible(false);
		add(scoreLabel);
		currentScoreLabel = new JLabel("lox");
		currentScoreLabel.setBounds(1500, 55, 100, 30);
		currentScoreLabel.setFont(mainFont);
		currentScoreLabel.setVisible(false);
		add(currentScoreLabel);
		surrenderButton = new JButton("Surrender");
		surrenderButton.setFont(mainFont);
		surrenderButton.setBounds(1500, 500, 200, 30);
		surrenderButton.setBackground(new Color(255, 255, 255));
		surrenderButton.setVisible(false);
		add(surrenderButton);
		getContentPane().setBackground(new Color(240, 240, 240));
		getContentPane().setBackground(new Color(240, 240, 240));
		disconnectFromServer();
		setSize(1920, 1080);
		setVisible(true);
	}

	public void connectToServer() {
		usernameTextField.setEnabled(false);
		passwordTextField.setEnabled(false);
		ipAddressTextField.setEnabled(false);
		portTextField.setEnabled(false);
		connectButton.setEnabled(false);
		disconnectButton.setEnabled(true);
		registerButton.setEnabled(false);
		playButton.setEnabled(true);
		levelOneButton.setEnabled(true);
		levelFiveButton.setEnabled(true);
		levelTenButton.setEnabled(true);
		levelFifteenButton.setEnabled(true);
		levelTwentyButton.setEnabled(true);
		levelTwentyFiveButton.setEnabled(true);
		tetrisGrid.setVisible(false);
		scoreLabel.setVisible(false);
		currentScoreLabel.setVisible(false);
		surrenderButton.setVisible(false);
		playButton.setVisible(true);
		levelOneButton.setVisible(true);
		levelFiveButton.setVisible(true);
		levelTenButton.setVisible(true);
		levelFifteenButton.setVisible(true);
		levelTwentyButton.setVisible(true);
		levelTwentyFiveButton.setVisible(true);
		nameScoreLabel.setVisible(true);
		scoreboardTable.setVisible(true);
		selectLevelLabel.setVisible(true);
	}

	public void disconnectFromServer() {
		usernameTextField.setEnabled(true);
		passwordTextField.setEnabled(true);
		ipAddressTextField.setEnabled(true);
		portTextField.setEnabled(true);
		connectButton.setEnabled(true);
		disconnectButton.setEnabled(false);
		registerButton.setEnabled(true);
		playButton.setEnabled(false);
		levelOneButton.setEnabled(false);
		levelFiveButton.setEnabled(false);
		levelTenButton.setEnabled(false);
		levelFifteenButton.setEnabled(false);
		levelTwentyButton.setEnabled(false);
		levelTwentyFiveButton.setEnabled(false);
		greetingsLabel.setVisible(false);
		tetrisGrid.setVisible(false);
		scoreLabel.setVisible(false);
		currentScoreLabel.setVisible(false);
		playButton.setVisible(true);
		levelOneButton.setVisible(true);
		levelFiveButton.setVisible(true);
		levelTenButton.setVisible(true);
		levelFifteenButton.setVisible(true);
		levelTwentyButton.setVisible(true);
		levelTwentyFiveButton.setVisible(true);
		nameScoreLabel.setVisible(true);
		scoreboardTable.setVisible(true);
		selectLevelLabel.setVisible(true);
		surrenderButton.setVisible(false);
	}

	public void playTetris() {
		usernameTextField.setEnabled(false);
		passwordTextField.setEnabled(false);
		ipAddressTextField.setEnabled(false);
		portTextField.setEnabled(false);
		connectButton.setEnabled(false);
		disconnectButton.setEnabled(true);
		registerButton.setEnabled(false);
		playButton.setVisible(false);
		levelOneButton.setVisible(false);
		levelFiveButton.setVisible(false);
		levelTenButton.setVisible(false);
		levelFifteenButton.setVisible(false);
		levelTwentyButton.setVisible(false);
		levelTwentyFiveButton.setVisible(false);
		nameScoreLabel.setVisible(false);
		scoreboardTable.setVisible(false);
		selectLevelLabel.setVisible(false);
		greetingsLabel.setVisible(false);
		tetrisGrid.setVisible(true);
		scoreLabel.setVisible(true);
		currentScoreLabel.setVisible(true);
		surrenderButton.setVisible(true);
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getIpLabel() {
		return ipLabel;
	}

	public void setIpLabel(JLabel ipLabel) {
		this.ipLabel = ipLabel;
	}

	public JLabel getPortLabel() {
		return portLabel;
	}

	public void setPortLabel(JLabel portLabel) {
		this.portLabel = portLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JLabel getNameScoreLabel() {
		return nameScoreLabel;
	}

	public void setNameScoreLabel(JLabel nameScoreLabel) {
		this.nameScoreLabel = nameScoreLabel;
	}

	public JLabel getShowUsernameLabel() {
		return showUsernameLabel;
	}

	public void setShowUsernameLabel(JLabel showUsernameLabel) {
		this.showUsernameLabel = showUsernameLabel;
	}

	public JLabel getGreetingsLabel() {
		return greetingsLabel;
	}

	public void setGreetingsLabel(JLabel greetingsLabel) {
		this.greetingsLabel = greetingsLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JLabel getSelectedLevelLabel() {
		return selectedLevelLabel;
	}

	public void setSelectedLevelLabel(JLabel selectedLevelLabel) {
		this.selectedLevelLabel = selectedLevelLabel;
	}

	public JLabel getCurrentScoreLabel() {
		return currentScoreLabel;
	}

	public void setCurrentScoreLabel(JLabel currentScoreLabel) {
		this.currentScoreLabel = currentScoreLabel;
	}

	public JLabel getCurrentLevelLabel() {
		return currentLevelLabel;
	}

	public void setCurrentLevelLabel(JLabel currentLevelLabel) {
		this.currentLevelLabel = currentLevelLabel;
	}

	public JLabel getSelectLevelLabel() {
		return selectLevelLabel;
	}

	public void setSelectLevelLabel(JLabel selectLevelLabel) {
		this.selectLevelLabel = selectLevelLabel;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}

	public JTextField getIpAddressTextField() {
		return ipAddressTextField;
	}

	public void setIpAddressTextField(JTextField ipAddressTextField) {
		this.ipAddressTextField = ipAddressTextField;
	}

	public JTextField getPortTextField() {
		return portTextField;
	}

	public void setPortTextField(JTextField portTextField) {
		this.portTextField = portTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(JTextField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public void setConnectButton(JButton connectButton) {
		this.connectButton = connectButton;
	}

	public JButton getDisconnectButton() {
		return disconnectButton;
	}

	public void setDisconnectButton(JButton disconnectButton) {
		this.disconnectButton = disconnectButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public void setPlayButton(JButton playButton) {
		this.playButton = playButton;
	}

	public JButton getLevelOneButton() {
		return levelOneButton;
	}

	public void setLevelOneButton(JButton levelOneButton) {
		this.levelOneButton = levelOneButton;
	}

	public JButton getLevelFiveButton() {
		return levelFiveButton;
	}

	public void setLevelFiveButton(JButton levelFiveButton) {
		this.levelFiveButton = levelFiveButton;
	}

	public JButton getLevelTenButton() {
		return levelTenButton;
	}

	public void setLevelTenButton(JButton levelTenButton) {
		this.levelTenButton = levelTenButton;
	}

	public JButton getLevelFifteenButton() {
		return levelFifteenButton;
	}

	public void setLevelFifteenButton(JButton levelFifteenButton) {
		this.levelFifteenButton = levelFifteenButton;
	}

	public JButton getLevelTwentyButton() {
		return levelTwentyButton;
	}

	public void setLevelTwentyButton(JButton levelTwentyButton) {
		this.levelTwentyButton = levelTwentyButton;
	}

	public JButton getLevelTwentyFiveButton() {
		return levelTwentyFiveButton;
	}

	public void setLevelTwentyFiveButton(JButton levelTwentyFiveButton) {
		this.levelTwentyFiveButton = levelTwentyFiveButton;
	}

	public JTable getScoreboardTable() {
		return scoreboardTable;
	}

	public void setScoreboardTable(JTable scoreboardTable) {
		this.scoreboardTable = scoreboardTable;
	}

	public Font getLevelFont() {
		return levelFont;
	}

	public void setLevelFont(Font levelFont) {
		this.levelFont = levelFont;
	}

	public TetrisGrid getTetrisGrid() {
		return tetrisGrid;
	}

	public void setTetrisGrid(TetrisGrid tetrisGrid) {
		this.tetrisGrid = tetrisGrid;
	}

	public int getChosenLevel() {
		return chosenLevel;
	}

	public void setChosenLevel(int choosenLevel) {
		this.chosenLevel = choosenLevel;
	}

	public JButton getSurrenderButton() {
		return surrenderButton;
	}

	public void setSurrenderButton(JButton surrenderButton) {
		this.surrenderButton = surrenderButton;
	}

	
}
