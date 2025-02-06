import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;

public class TicTacToeGame extends JPanel implements MouseListener
{
    AudioStream song; // plays in background

    Image title;
    Image background;
    Image backgroundChoice;
    Image xImage;
    Image oImage;
    Image cImage;
    Image xImageMed;
    Image oImageMed;
    Image cImageMed;
    Image xImageHard;
    Image oImageHard;
    Image cImageHard;
    Image xWin;
    Image oWin;
    Image Tie;
    Image cWin;
    Image tieImage;

    int screen = 1; // what screen we're on
    int players; // how many players
    int turn = 1; // whose turn it is (1 or 2)
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e1 = 0;
    int f = 0;
    int g1 = 0;
    int h = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    //for the hard mode
    int a1 = 0;
    int b1 = 0;
    int c1 = 0;
    int d1 = 0;
    int e11 = 0;
    int f1 = 0;
    int g11 = 0;
    int h1 = 0;
    int i1 = 0;
    int a2 = 0;
    int b2 = 0;
    int c2 = 0;
    int d2 = 0;
    int e2 = 0;
    int f2 = 0;
    int g2 = 0;
    int h2 = 0;
    int i2 = 0;
    int a3 = 0;
    int b3 = 0;
    int c3 = 0;
    int d3 = 0;
    int e3 = 0;
    int f3 = 0;
    int g3 = 0;
    int h3 = 0;
    int i3 = 0;
    int a4 = 0;
    int b4 = 0;
    int c4 = 0;
    int d4 = 0;
    int e4 = 0;
    int f4 = 0;
    int g4 = 0;
    int h4 = 0;
    int i4 = 0;
    int a5 = 0;
    int b5 = 0;
    int c5 = 0;
    int d5 = 0;
    int e5 = 0;
    int f5 = 0;
    int g5 = 0;
    int h5 = 0;
    int i5 = 0;
    int a6 = 0;
    int b6 = 0;
    int c6 = 0;
    int d6 = 0;
    int e6 = 0;
    int f6 = 0;
    int g6 = 0;
    int h6 = 0;
    int i6 = 0;
    int a7 = 0;
    int b7 = 0;
    int c7 = 0;
    int d7 = 0;
    int e7 = 0;
    int f7 = 0;
    int g7 = 0;
    int h7 = 0;
    int i7 = 0;
    int a8 = 0;
    int b8 = 0;
    int c8 = 0;
    int d8 = 0;
    int e8 = 0;
    int f8 = 0;
    int g8 = 0;
    int h8 = 0;
    int i8 = 0;
    // for big squares in hard mode
    int r = 0; 
    int s = 0;
    int t = 0;
    int u = 0;
    int v = 0;
    int w = 0;
    int x1 = 0;
    int y1 = 0;
    int z = 0;
    int corner; // computer picks a corner for first move

    public TicTacToeGame()
    {
        addMouseListener(this);

        // load images
        try
        {
            title = ImageIO.read(new File("Title4.jpg"));
            background = ImageIO.read(new File("Background.jpg"));
            backgroundChoice = ImageIO.read(new File("backgroundChoice.jpg"));
            xImage = ImageIO.read(new File("Penguin 1.png"));
            oImage = ImageIO.read(new File("Mouse 2.png"));
            cImage = ImageIO.read(new File("Yeti.png"));
            xImageMed = ImageIO.read(new File("Penguin 1 Med.png"));
            oImageMed = ImageIO.read(new File("Mouse 2 Med.png"));
            cImageMed = ImageIO.read(new File("Yeti Med.png"));
            xImageHard = ImageIO.read(new File("Penguin 1 Hard.png"));
            oImageHard = ImageIO.read(new File("Mouse 2 Hard.png"));
            cImageHard = ImageIO.read(new File("Yeti Hard.png"));
            xWin = ImageIO.read(new File("xWin.jpg"));
            oWin = ImageIO.read(new File("oWin.jpg"));
            Tie = ImageIO.read(new File("Tie.jpg"));
            cWin = ImageIO.read(new File("cWin.jpg"));
            tieImage = ImageIO.read(new File("Tie Image.png"));
            song = new AudioStream(new FileInputStream("Blizzard2.wav"));
        }
        catch (IOException e)
        {

        }
        // play noise
        AudioPlayer.player.start(song);
    }

    public void paint(Graphics g)
    {
        if (screen == 1)
        {
            startScreen(g); 
        }
        else if (screen == 2)
        {
            drawBoard(g); 
        }
        else if (screen == 3)
        {
            delay(50000);
            drawXWin(g);
        }
        else if (screen == 4)
        {
            delay(50000);
            drawOWin(g);  
        }
        else if (screen == 5)
        {
            delay(50000);
            drawTie(g); 
        }
        else if (screen == 6)
        {
            delay(50000);
            drawCWin(g); 
        }
        else if (screen == 7)
        {
            ModeSelect(g); 
        }
        else if (screen == 8)
        {
            drawBoardMedium(g);
        }
        else if (screen == 9)
        {
            drawBoardHard(g);
        }
    }

    public void startScreen(Graphics g)
    {
        g.drawImage(title, 0, 0, null);

        //draw 1 Player button
        g.setColor(Color.white);
        g.fillRect(100, 600, 300, 100);
        g.setColor(Color.black);
        g.drawString("ONE PLAYER", 210, 655);

        //draw 2 player button
        g.setColor(Color.white);
        g.fillRect(500, 600, 300, 100);
        g.setColor(Color.black);
        g.drawString("TWO PLAYER", 610, 655);

    }

    public void ModeSelect(Graphics g) //pick which game mode to play
    {
        g.drawImage(backgroundChoice, 0, 0, null);
        // easy button
        g.setColor(Color.white);
        g.fillRect(45, 500, 165, 100);
        g.setColor(Color.black);
        g.drawString("EASY", 113, 555);
        // medium button
        g.setColor(Color.white);
        g.fillRect(360, 500, 165, 100);
        g.setColor(Color.black);
        g.drawString("MEDIUM", 420, 555);
        // hard button
        g.setColor(Color.white);
        g.fillRect(685, 500, 155, 100);
        g.setColor(Color.black);
        g.drawString("HARD", 745, 555);
    }

    public void drawBoard(Graphics g) // 3x3 board
    {
        g.drawImage(background, 0, 0, null);

        g.setColor(Color.black);
        g.fillRect(297, 0, 6, 900);
        g.fillRect(597, 0, 6, 900);
        g.fillRect(0, 297, 900, 6);
        g.fillRect(0, 597, 900, 6);

        if (a == 1)
            g.drawImage(xImage, 0, 0, null);
        else if (players == 1 && a == 2)
            g.drawImage(cImage, 0, 0, null);
        else if (a == 2)
            g.drawImage(oImage, 0, 0, null);

        if (b == 1)
            g.drawImage(xImage, 303, 0, null);
        else if (players == 1 && b == 2)
            g.drawImage(cImage, 303, 0, null);
        else if (b == 2)
            g.drawImage(oImage, 303, 0, null);

        if (c == 1)
            g.drawImage(xImage, 603, 0, null);
        else if (players == 1 && c == 2)
            g.drawImage(cImage, 603, 0, null);
        else if (c == 2)
            g.drawImage(oImage, 603, 0, null);

        if (d == 1)
            g.drawImage(xImage, 0, 303, null);
        else if (players == 1 && d == 2)
            g.drawImage(cImage, 0, 303, null);
        else if (d == 2)
            g.drawImage(oImage, 0, 303, null);

        if (e1 == 1)
            g.drawImage(xImage, 303, 303, null);
        else if (players == 1 && e1 == 2)
            g.drawImage(cImage, 303, 303, null);
        else if (e1 == 2)
            g.drawImage(oImage, 303, 303, null);

        if (f == 1)
            g.drawImage(xImage, 603, 303, null);
        else if (players == 1 && f == 2)
            g.drawImage(cImage, 603, 303, null);
        else if (f == 2)
            g.drawImage(oImage, 603, 303, null);

        if (g1 == 1)
            g.drawImage(xImage, 0, 603, null);
        else if (players == 1 && g1 == 2)
            g.drawImage(cImage, 0, 603, null);
        else if (g1 == 2)
            g.drawImage(oImage, 0, 603, null);

        if (h == 1)
            g.drawImage(xImage, 303, 603, null);
        else if (players == 1 && h == 2)
            g.drawImage(cImage, 303, 603, null);
        else if (h == 2)
            g.drawImage(oImage, 303, 603, null);

        if (i == 1)
            g.drawImage(xImage, 603, 603, null);
        else if (players == 1 && i == 2)
            g.drawImage(cImage, 603, 603, null);
        else if (i == 2)
            g.drawImage(oImage, 603, 603, null);

        if (players == 2)
            checkWinner();
        else
            checkWinner2();
    }

    public void drawBoardMedium(Graphics g) // 4x4 board
    {
        g.drawImage(background, 0, 0, null);

        g.setColor(Color.black);
        g.fillRect(222, 0, 6, 900);
        g.fillRect(450, 0, 6, 900);
        g.fillRect(678, 0, 6, 900);
        g.fillRect(0, 222, 900, 6);
        g.fillRect(0, 450, 900, 6);
        g.fillRect(0, 678, 900, 6);

        if (a == 1)
            g.drawImage(xImageMed, 0, 0, null);
        else if (players == 1 && a == 2)
            g.drawImage(cImageMed, 0, 0, null);
        else if (a == 2)
            g.drawImage(oImageMed, 0, 0, null);

        if (b == 1)
            g.drawImage(xImageMed, 228, 0, null);
        else if (players == 1 && b == 2)
            g.drawImage(cImageMed, 228, 0, null);
        else if (b == 2)
            g.drawImage(oImageMed, 228, 0, null);

        if (c == 1)
            g.drawImage(xImageMed, 456, 0, null);
        else if (players == 1 && c == 2)
            g.drawImage(cImageMed, 456, 0, null);
        else if (c == 2)
            g.drawImage(oImageMed, 456, 0, null);

        if (d == 1)
            g.drawImage(xImageMed, 684, 0, null);
        else if (players == 1 && d == 2)
            g.drawImage(cImageMed, 684, 0, null);
        else if (d == 2)
            g.drawImage(oImageMed, 684, 0, null);

        if (e1 == 1)
            g.drawImage(xImageMed, 0, 228, null);
        else if (players == 1 && e1 == 2)
            g.drawImage(cImageMed, 0, 228, null);
        else if (e1 == 2)
            g.drawImage(oImageMed, 0, 228, null);

        if (f == 1)
            g.drawImage(xImageMed, 228, 228, null);
        else if (players == 1 && f == 2)
            g.drawImage(cImageMed, 228, 228, null);
        else if (f == 2)
            g.drawImage(oImageMed, 228, 228, null);

        if (g1 == 1)
            g.drawImage(xImageMed, 456, 228, null);
        else if (players == 1 && g1 == 2)
            g.drawImage(cImageMed, 456, 228, null);
        else if (g1 == 2)
            g.drawImage(oImageMed, 456, 228, null);

        if (h == 1)
            g.drawImage(xImageMed, 684, 228, null);
        else if (players == 1 && h == 2)
            g.drawImage(cImageMed, 684, 228, null);
        else if (h == 2)
            g.drawImage(oImageMed, 684, 228, null);

        if (i == 1)
            g.drawImage(xImageMed, 0, 456, null);
        else if (players == 1 && i == 2)
            g.drawImage(cImageMed, 0, 456, null);
        else if (i == 2)
            g.drawImage(oImageMed, 0, 456, null);

        if (j == 1)
            g.drawImage(xImageMed, 228, 456, null);
        else if (players == 1 && j == 2)
            g.drawImage(cImageMed, 228, 456, null);
        else if (j == 2)
            g.drawImage(oImageMed, 228, 456, null);

        if (k == 1)
            g.drawImage(xImageMed, 456, 456, null);
        else if (players == 1 && k == 2)
            g.drawImage(cImageMed, 456, 456, null);
        else if (k == 2)
            g.drawImage(oImageMed, 456, 456, null);

        if (l == 1)
            g.drawImage(xImageMed, 684, 456, null);
        else if (players == 1 && l == 2)
            g.drawImage(cImageMed, 684, 456, null);
        else if (l == 2)
            g.drawImage(oImageMed, 684, 456, null);

        if (m == 1)
            g.drawImage(xImageMed, 0, 684, null);
        else if (players == 1 && m == 2)
            g.drawImage(cImageMed, 0, 684, null);
        else if (m == 2)
            g.drawImage(oImageMed, 0, 684, null);

        if (n == 1)
            g.drawImage(xImageMed, 228, 684, null);
        else if (players == 1 && n == 2)
            g.drawImage(cImageMed, 228, 684, null);
        else if (n == 2)
            g.drawImage(oImageMed, 228, 684, null);

        if (o == 1)
            g.drawImage(xImageMed, 456, 684, null);
        else if (players == 1 && o == 2)
            g.drawImage(cImageMed, 456, 684, null);
        else if (o == 2)
            g.drawImage(oImageMed, 456, 684, null);

        if (p == 1)
            g.drawImage(xImageMed, 684, 684, null);
        else if (players == 1 && p == 2)
            g.drawImage(cImageMed, 684, 684, null);
        else if (p == 2)
            g.drawImage(oImageMed, 684, 684, null);

        if (players == 2)
            checkWinnerMed();
        else
            checkWinnerMed2();
    }

    public void drawBoardHard(Graphics g) // big board
    {
        g.drawImage(background, 0, 0, null);

        g.setColor(Color.black);
        g.fillRect(297, 0, 6, 900);
        g.fillRect(597, 0, 6, 900);
        g.fillRect(0, 297, 900, 6);
        g.fillRect(0, 597, 900, 6);

        //inner boards
        //vertical lines
        g.fillRect(99, 0, 2, 900);
        g.fillRect(199, 0, 2, 900);
        g.fillRect(399, 0, 2, 900);
        g.fillRect(499, 0 , 2, 900);
        g.fillRect(699, 0, 2, 900);
        g.fillRect(799, 0 , 2, 900);
        //horizontal lines
        g.fillRect(0, 99, 900, 2);
        g.fillRect(0, 199, 900, 2);
        g.fillRect(0, 399, 900, 2);
        g.fillRect(0, 499, 900, 2);
        g.fillRect(0, 699, 900, 2);
        g.fillRect(0, 799, 900, 2);

        // box r
        if (a == 1)
            g.drawImage(xImageHard, 0, 0, null);
        else if (players == 1 && a == 2)
            g.drawImage(cImageHard, 0, 0, null);
        else if (a == 2)
            g.drawImage(oImageHard, 0, 0, null);

        if (b == 1)
            g.drawImage(xImageHard, 100, 0, null);
        else if (players == 1 && b == 2)
            g.drawImage(cImageHard, 100, 0, null);
        else if (b == 2)
            g.drawImage(oImageHard, 100, 0, null);

        if (c == 1)
            g.drawImage(xImageHard, 200, 0, null);
        else if (players == 1 && c == 2)
            g.drawImage(cImageHard, 200, 0, null);
        else if (c == 2)
            g.drawImage(oImageHard, 200, 0, null);

        if (d == 1)
            g.drawImage(xImageHard, 0, 100, null);
        else if (players == 1 && d == 2)
            g.drawImage(cImageHard, 0, 100, null);
        else if (d == 2)
            g.drawImage(oImageHard, 0, 100, null);

        if (e1 == 1)
            g.drawImage(xImageHard, 100, 100, null);
        else if (players == 1 && e1 == 2)
            g.drawImage(cImageHard, 100, 100, null);
        else if (e1 == 2)
            g.drawImage(oImageHard, 100, 100, null);

        if (f == 1)
            g.drawImage(xImageHard, 200, 100, null);
        else if (players == 1 && f == 2)
            g.drawImage(cImageHard, 200, 100, null);
        else if (f == 2)
            g.drawImage(oImageHard, 200, 100, null);

        if (g1 == 1)
            g.drawImage(xImageHard, 0, 200, null);
        else if (players == 1 && g1 == 2)
            g.drawImage(cImageHard, 0, 200, null);
        else if (g1 == 2)
            g.drawImage(oImageHard, 0, 200, null);

        if (h == 1)
            g.drawImage(xImageHard, 100, 200, null);
        else if (players == 1 && h == 2)
            g.drawImage(cImageHard, 100, 200, null);
        else if (h == 2)
            g.drawImage(oImageHard, 100, 200, null);

        if (i == 1)
            g.drawImage(xImageHard, 200, 200, null);
        else if (players == 1 && i == 2)
            g.drawImage(cImageHard, 200, 200, null);
        else if (i == 2)
            g.drawImage(oImageHard, 200, 200, null);

        // box s
        if (a1 == 1)
            g.drawImage(xImageHard, 300, 0, null);
        else if (players == 1 && a1 == 2)
            g.drawImage(cImageHard, 300, 0, null);
        else if (a1 == 2)
            g.drawImage(oImageHard, 300, 0, null);

        if (b1 == 1)
            g.drawImage(xImageHard, 400, 0, null);
        else if (players == 1 && b1 == 2)
            g.drawImage(cImageHard, 400, 0, null);
        else if (b1 == 2)
            g.drawImage(oImageHard, 400, 0, null);

        if (c1 == 1)
            g.drawImage(xImageHard, 500, 0, null);
        else if (players == 1 && c1 == 2)
            g.drawImage(cImageHard, 500, 0, null);
        else if (c1 == 2)
            g.drawImage(oImageHard, 500, 0, null);

        if (d1 == 1)
            g.drawImage(xImageHard, 300, 100, null);
        else if (players == 1 && d1 == 2)
            g.drawImage(cImageHard, 300, 100, null);
        else if (d1 == 2)
            g.drawImage(oImageHard, 300, 100, null);

        if (e11 == 1)
            g.drawImage(xImageHard, 400, 100, null);
        else if (players == 1 && e11 == 2)
            g.drawImage(cImageHard, 400, 100, null);
        else if (e11 == 2)
            g.drawImage(oImageHard, 400, 100, null);

        if (f1 == 1)
            g.drawImage(xImageHard, 500, 100, null);
        else if (players == 1 && f1 == 2)
            g.drawImage(cImageHard, 500, 100, null);
        else if (f1 == 2)
            g.drawImage(oImageHard, 500, 100, null);

        if (g11 == 1)
            g.drawImage(xImageHard, 300, 200, null);
        else if (players == 1 && g11 == 2)
            g.drawImage(cImageHard, 300, 200, null);
        else if (g11 == 2)
            g.drawImage(oImageHard, 300, 200, null);

        if (h1 == 1)
            g.drawImage(xImageHard, 400, 200, null);
        else if (players == 1 && h1 == 2)
            g.drawImage(cImageHard, 400, 200, null);
        else if (h1 == 2)
            g.drawImage(oImageHard, 400, 200, null);

        if (i1 == 1)
            g.drawImage(xImageHard, 500, 200, null);
        else if (players == 1 && i1 == 2)
            g.drawImage(cImageHard, 500, 200, null);
        else if (i1 == 2)
            g.drawImage(oImageHard, 500, 200, null);

        // box t
        if (a2 == 1)
            g.drawImage(xImageHard, 600, 0, null);
        else if (players == 1 && a2 == 2)
            g.drawImage(cImageHard, 600, 0, null);
        else if (a2 == 2)
            g.drawImage(oImageHard, 600, 0, null);

        if (b2 == 1)
            g.drawImage(xImageHard, 700, 0, null);
        else if (players == 1 && b2 == 2)
            g.drawImage(cImageHard, 700, 0, null);
        else if (b2 == 2)
            g.drawImage(oImageHard, 700, 0, null);

        if (c2 == 1)
            g.drawImage(xImageHard, 800, 0, null);
        else if (players == 1 && c2 == 2)
            g.drawImage(cImageHard, 800, 0, null);
        else if (c2 == 2)
            g.drawImage(oImageHard, 800, 0, null);

        if (d2 == 1)
            g.drawImage(xImageHard, 600, 100, null);
        else if (players == 1 && d2 == 2)
            g.drawImage(cImageHard, 600, 100, null);
        else if (d2 == 2)
            g.drawImage(oImageHard, 600, 100, null);

        if (e2 == 1)
            g.drawImage(xImageHard, 700, 100, null);
        else if (players == 1 && e2 == 2)
            g.drawImage(cImageHard, 700, 100, null);
        else if (e2 == 2)
            g.drawImage(oImageHard, 700, 100, null);

        if (f2 == 1)
            g.drawImage(xImageHard, 800, 100, null);
        else if (players == 1 && f2 == 2)
            g.drawImage(cImageHard, 800, 100, null);
        else if (f2 == 2)
            g.drawImage(oImageHard, 800, 100, null);

        if (g2 == 1)
            g.drawImage(xImageHard, 600, 200, null);
        else if (players == 1 && g2 == 2)
            g.drawImage(cImageHard, 600, 200, null);
        else if (g2 == 2)
            g.drawImage(oImageHard, 600, 200, null);

        if (h2 == 1)
            g.drawImage(xImageHard, 700, 200, null);
        else if (players == 1 && h2 == 2)
            g.drawImage(cImageHard, 700, 200, null);
        else if (h2 == 2)
            g.drawImage(oImageHard, 700, 200, null);

        if (i2 == 1)
            g.drawImage(xImageHard, 800, 200, null);
        else if (players == 1 && i2 == 2)
            g.drawImage(cImageHard, 800, 200, null);
        else if (i2 == 2)
            g.drawImage(oImageHard, 800, 200, null);   

        // box u
        if (a3 == 1)
            g.drawImage(xImageHard, 0, 300, null);
        else if (players == 1 && a3 == 2)
            g.drawImage(cImageHard, 0, 300, null);
        else if (a3 == 2)
            g.drawImage(oImageHard, 0, 300, null);

        if (b3 == 1)
            g.drawImage(xImageHard, 100, 300, null);
        else if (players == 1 && b3 == 2)
            g.drawImage(cImageHard, 100, 300, null);
        else if (b3 == 2)
            g.drawImage(oImageHard, 100, 300, null);

        if (c3 == 1)
            g.drawImage(xImageHard, 200, 300, null);
        else if (players == 1 && c3 == 2)
            g.drawImage(cImageHard, 200, 300, null);
        else if (c3 == 2)
            g.drawImage(oImageHard, 200, 300, null);

        if (d3 == 1)
            g.drawImage(xImageHard, 0, 400, null);
        else if (players == 1 && d3 == 2)
            g.drawImage(cImageHard, 0, 400, null);
        else if (d3 == 2)
            g.drawImage(oImageHard, 0, 400, null);

        if (e3 == 1)
            g.drawImage(xImageHard, 100, 400, null);
        else if (players == 1 && e3 == 2)
            g.drawImage(cImageHard, 100, 400, null);
        else if (e3 == 2)
            g.drawImage(oImageHard, 100, 400, null);

        if (f3 == 1)
            g.drawImage(xImageHard, 200, 400, null);
        else if (players == 1 && f3 == 2)
            g.drawImage(cImageHard, 200, 400, null);
        else if (f3 == 2)
            g.drawImage(oImageHard, 200, 400, null);

        if (g3 == 1)
            g.drawImage(xImageHard, 0, 500, null);
        else if (players == 1 && g3 == 2)
            g.drawImage(cImageHard, 0, 500, null);
        else if (g3 == 2)
            g.drawImage(oImageHard, 0, 500, null);

        if (h3 == 1)
            g.drawImage(xImageHard, 100, 500, null);
        else if (players == 1 && h3 == 2)
            g.drawImage(cImageHard, 100, 500, null);
        else if (h3 == 2)
            g.drawImage(oImageHard, 100, 500, null);

        if (i3 == 1)
            g.drawImage(xImageHard, 200, 500, null);
        else if (players == 1 && i3 == 2)
            g.drawImage(cImageHard, 200, 500, null);
        else if (i3 == 2)
            g.drawImage(oImageHard, 200, 500, null);

        // box v
        if (a4 == 1)
            g.drawImage(xImageHard, 300, 300, null);
        else if (players == 1 && a4 == 2)
            g.drawImage(cImageHard, 300, 300, null);
        else if (a4 == 2)
            g.drawImage(oImageHard, 300, 300, null);

        if (b4 == 1)
            g.drawImage(xImageHard, 400, 300, null);
        else if (players == 1 && b4 == 2)
            g.drawImage(cImageHard, 400, 300, null);
        else if (b4 == 2)
            g.drawImage(oImageHard, 400, 300, null);

        if (c4 == 1)
            g.drawImage(xImageHard, 500, 300, null);
        else if (players == 1 && c4 == 2)
            g.drawImage(cImageHard, 500, 300, null);
        else if (c4 == 2)
            g.drawImage(oImageHard, 500, 300, null);

        if (d4 == 1)
            g.drawImage(xImageHard, 300, 400, null);
        else if (players == 1 && d4 == 2)
            g.drawImage(cImageHard, 300, 400, null);
        else if (d4 == 2)
            g.drawImage(oImageHard, 300, 400, null);

        if (e4 == 1)
            g.drawImage(xImageHard, 400, 400, null);
        else if (players == 1 && e4 == 2)
            g.drawImage(cImageHard, 400, 400, null);
        else if (e4 == 2)
            g.drawImage(oImageHard, 400, 400, null);

        if (f4 == 1)
            g.drawImage(xImageHard, 500, 400, null);
        else if (players == 1 && f4 == 2)
            g.drawImage(cImageHard, 500, 400, null);
        else if (f4 == 2)
            g.drawImage(oImageHard, 500, 400, null);

        if (g4 == 1)
            g.drawImage(xImageHard, 300, 500, null);
        else if (players == 1 && g4 == 2)
            g.drawImage(cImageHard, 300, 500, null);
        else if (g4 == 2)
            g.drawImage(oImageHard, 300, 500, null);

        if (h4 == 1)
            g.drawImage(xImageHard, 400, 500, null);
        else if (players == 1 && h4 == 2)
            g.drawImage(cImageHard, 400, 500, null);
        else if (h4 == 2)
            g.drawImage(oImageHard, 400, 500, null);

        if (i4 == 1)
            g.drawImage(xImageHard, 500, 500, null);
        else if (players == 1 && i4 == 2)
            g.drawImage(cImageHard, 500, 500, null);
        else if (i4 == 2)
            g.drawImage(oImageHard, 500, 500, null);

        // box w
        if (a5 == 1)
            g.drawImage(xImageHard, 600, 300, null);
        else if (players == 1 && a5 == 2)
            g.drawImage(cImageHard, 600, 300, null);
        else if (a5 == 2)
            g.drawImage(oImageHard, 600, 300, null);

        if (b5 == 1)
            g.drawImage(xImageHard, 700, 300, null);
        else if (players == 1 && b5 == 2)
            g.drawImage(cImageHard, 700, 300, null);
        else if (b5 == 2)
            g.drawImage(oImageHard, 700, 300, null);

        if (c5 == 1)
            g.drawImage(xImageHard, 800, 300, null);
        else if (players == 1 && c5 == 2)
            g.drawImage(cImageHard, 800, 300, null);
        else if (c5 == 2)
            g.drawImage(oImageHard, 800, 300, null);

        if (d5 == 1)
            g.drawImage(xImageHard, 600, 400, null);
        else if (players == 1 && d5 == 2)
            g.drawImage(cImageHard, 600, 400, null);
        else if (d5 == 2)
            g.drawImage(oImageHard, 600, 400, null);

        if (e5 == 1)
            g.drawImage(xImageHard, 700, 400, null);
        else if (players == 1 && e5 == 2)
            g.drawImage(cImageHard, 700, 400, null);
        else if (e5 == 2)
            g.drawImage(oImageHard, 700, 400, null);

        if (f5 == 1)
            g.drawImage(xImageHard, 800, 400, null);
        else if (players == 1 && f5 == 2)
            g.drawImage(cImageHard, 800, 400, null);
        else if (f5 == 2)
            g.drawImage(oImageHard, 800, 400, null);

        if (g5 == 1)
            g.drawImage(xImageHard, 600, 500, null);
        else if (players == 1 && g5 == 2)
            g.drawImage(cImageHard, 600, 500, null);
        else if (g5 == 2)
            g.drawImage(oImageHard, 600, 500, null);

        if (h5 == 1)
            g.drawImage(xImageHard, 700, 500, null);
        else if (players == 1 && h5 == 2)
            g.drawImage(cImageHard, 700, 500, null);
        else if (h5 == 2)
            g.drawImage(oImageHard, 700, 500, null);

        if (i5 == 1)
            g.drawImage(xImageHard, 800, 500, null);
        else if (players == 1 && i5 == 2)
            g.drawImage(cImageHard, 800, 500, null);
        else if (i5 == 2)
            g.drawImage(oImageHard, 800, 500, null);   

        // big box x1
        if (a6 == 1)
            g.drawImage(xImageHard, 0, 600, null);
        else if (players == 1 && a6 == 2)
            g.drawImage(cImageHard, 0, 600, null);
        else if (a6 == 2)
            g.drawImage(oImageHard, 0, 600, null);

        if (b6 == 1)
            g.drawImage(xImageHard, 100, 600, null);
        else if (players == 1 && b6 == 2)
            g.drawImage(cImageHard, 100, 600, null);
        else if (b6 == 2)
            g.drawImage(oImageHard, 100, 600, null);

        if (c6 == 1)
            g.drawImage(xImageHard, 200, 600, null);
        else if (players == 1 && c6 == 2)
            g.drawImage(cImageHard, 200, 600, null);
        else if (c6 == 2)
            g.drawImage(oImageHard, 200, 600, null);

        if (d6 == 1)
            g.drawImage(xImageHard, 0, 700, null);
        else if (players == 1 && d6 == 2)
            g.drawImage(cImageHard, 0, 700, null);
        else if (d6 == 2)
            g.drawImage(oImageHard, 0, 700, null);

        if (e6 == 1)
            g.drawImage(xImageHard, 100, 700, null);
        else if (players == 1 && e6 == 2)
            g.drawImage(cImageHard, 100, 700, null);
        else if (e6 == 2)
            g.drawImage(oImageHard, 100, 700, null);

        if (f6 == 1)
            g.drawImage(xImageHard, 200, 700, null);
        else if (players == 1 && f6 == 2)
            g.drawImage(cImageHard, 200, 700, null);
        else if (f6 == 2)
            g.drawImage(oImageHard, 200, 700, null);

        if (g6 == 1)
            g.drawImage(xImageHard, 0, 800, null);
        else if (players == 1 && g6 == 2)
            g.drawImage(cImageHard, 0, 800, null);
        else if (g6 == 2)
            g.drawImage(oImageHard, 0, 800, null);

        if (h6 == 1)
            g.drawImage(xImageHard, 100, 800, null);
        else if (players == 1 && h6 == 2)
            g.drawImage(cImageHard, 100, 800, null);
        else if (h6 == 2)
            g.drawImage(oImageHard, 100, 800, null);

        if (i6 == 1)
            g.drawImage(xImageHard, 200, 800, null);
        else if (players == 1 && i6 == 2)
            g.drawImage(cImageHard, 200, 800, null);
        else if (i6 == 2)
            g.drawImage(oImageHard, 200, 800, null);

        // big box y1
        if (a7 == 1)
            g.drawImage(xImageHard, 300, 600, null);
        else if (players == 1 && a7 == 2)
            g.drawImage(cImageHard, 300, 600, null);
        else if (a7 == 2)
            g.drawImage(oImageHard, 300, 600, null);

        if (b7 == 1)
            g.drawImage(xImageHard, 400, 600, null);
        else if (players == 1 && b7 == 2)
            g.drawImage(cImageHard, 400, 600, null);
        else if (b7 == 2)
            g.drawImage(oImageHard, 400, 600, null);

        if (c7 == 1)
            g.drawImage(xImageHard, 500, 600, null);
        else if (players == 1 && c7 == 2)
            g.drawImage(cImageHard, 500, 600, null);
        else if (c7 == 2)
            g.drawImage(oImageHard, 500, 600, null);

        if (d7 == 1)
            g.drawImage(xImageHard, 300, 700, null);
        else if (players == 1 && d7 == 2)
            g.drawImage(cImageHard, 300, 700, null);
        else if (d7 == 2)
            g.drawImage(oImageHard, 300, 700, null);

        if (e7 == 1)
            g.drawImage(xImageHard, 400, 700, null);
        else if (players == 1 && e7 == 2)
            g.drawImage(cImageHard, 400, 700, null);
        else if (e7 == 2)
            g.drawImage(oImageHard, 400, 700, null);

        if (f7 == 1)
            g.drawImage(xImageHard, 500, 700, null);
        else if (players == 1 && f7 == 2)
            g.drawImage(cImageHard, 500, 700, null);
        else if (f7 == 2)
            g.drawImage(oImageHard, 500, 700, null);

        if (g7 == 1)
            g.drawImage(xImageHard, 300,800, null);
        else if (players == 1 && g7 == 2)
            g.drawImage(cImageHard, 300, 800, null);
        else if (g7 == 2)
            g.drawImage(oImageHard, 300, 800, null);

        if (h7 == 1)
            g.drawImage(xImageHard, 400, 800, null);
        else if (players == 1 && h7 == 2)
            g.drawImage(cImageHard, 400, 800, null);
        else if (h7 == 2)
            g.drawImage(oImageHard, 400, 800, null);

        if (i7 == 1)
            g.drawImage(xImageHard, 500, 800, null);
        else if (players == 1 && i7 == 2)
            g.drawImage(cImageHard, 500, 800, null);
        else if (i7 == 2)
            g.drawImage(oImageHard, 500, 800, null);

        // box z
        if (a8 == 1)
            g.drawImage(xImageHard, 600, 600, null);
        else if (players == 1 && a8 == 2)
            g.drawImage(cImageHard, 600, 600, null);
        else if (a8 == 2)
            g.drawImage(oImageHard, 600, 600, null);

        if (b8 == 1)
            g.drawImage(xImageHard, 700, 600, null);
        else if (players == 1 && b8 == 2)
            g.drawImage(cImageHard, 700, 600, null);
        else if (b8 == 2)
            g.drawImage(oImageHard, 700, 600, null);

        if (c8 == 1)
            g.drawImage(xImageHard, 800, 600, null);
        else if (players == 1 && c8 == 2)
            g.drawImage(cImageHard, 800, 600, null);
        else if (c8 == 2)
            g.drawImage(oImageHard, 800, 600, null);

        if (d8 == 1)
            g.drawImage(xImageHard, 600, 700, null);
        else if (players == 1 && d8 == 2)
            g.drawImage(cImageHard, 600, 700, null);
        else if (d8 == 2)
            g.drawImage(oImageHard, 600, 700, null);

        if (e8 == 1)
            g.drawImage(xImageHard, 700, 700, null);
        else if (players == 1 && e8 == 2)
            g.drawImage(cImageHard, 700, 700, null);
        else if (e8 == 2)
            g.drawImage(oImageHard, 700, 700, null);

        if (f8 == 1)
            g.drawImage(xImageHard, 800, 700, null);
        else if (players == 1 && f8 == 2)
            g.drawImage(cImageHard, 800, 700, null);
        else if (f8 == 2)
            g.drawImage(oImageHard, 800, 700, null);

        if (g8 == 1)
            g.drawImage(xImageHard, 600, 800, null);
        else if (players == 1 && g8 == 2)
            g.drawImage(cImageHard, 600, 800, null);
        else if (g8 == 2)
            g.drawImage(oImageHard, 600, 800, null);

        if (h8 == 1)
            g.drawImage(xImageHard, 700, 800, null);
        else if (players == 1 && h8 == 2)
            g.drawImage(cImageHard, 700, 800, null);
        else if (h8 == 2)
            g.drawImage(oImageHard, 700, 800, null);

        if (i8 == 1)
            g.drawImage(xImageHard, 800, 800, null);
        else if (players == 1 && i8 == 2)
            g.drawImage(cImageHard, 800, 800, null);
        else if (i8 == 2)
            g.drawImage(oImageHard, 800, 800, null);  

        // check winner in each square
        // big box r
        if (a == 1 && b == 1 && c == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (d == 1 && e1 == 1 && f == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (g1 == 1 && h == 1 && i == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (a == 1 && d == 1 && g1 == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (b == 1 && e1 == 1 && h == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (c == 1 && f == 1 && i == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (a == 1 && e1 == 1 && i == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        }
        else if (c == 1 && e1 == 1 && g1 == 1)
        {
            g.drawImage(xImage, 0, 0, null);
            r = 1;
        } 
        // check if player 2 wins
        else if (a == 2 && b == 2 && c == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (d == 2 && e1 == 2 && f == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (g1 == 2 && h == 2 && i == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (a == 2 && d == 2 && g1 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (b == 2 && e1 == 2 && h == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if ( c == 2 && f == 2 && i == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (a == 2 && e1 == 2 && i == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        else if (c == 2 && e1 == 2 && g1 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 0, null);
            r = 2;
        }
        // check if computer wins
        else if (a == 2 && b == 2 && c == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (d == 2 && e1 == 2 && f == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (g1 == 2 && h == 2 && i == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (a == 2 && d == 2 && g1 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (b == 2 && e1 == 2 && h == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if ( c == 2 && f == 2 && i == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (a == 2 && e1 == 2 && i == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }
        else if (c == 2 && e1 == 2 && g1 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 0, null);
            r = 2;
        }

        else if (a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0)
        {
            r = 3;
            g.drawImage(tieImage, 0, 0, null);
        }

        // big box s
        if (a1 == 1 && b1 == 1 && c1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (d1 == 1 && e11 == 1 && f1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (g11 == 1 && h1 == 1 && i1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        } 
        else if (a1 == 1 && d1 == 1 && g11 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (b1 == 1 && e11 == 1 && h1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (c1 == 1 && f1 == 1 && i1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (a1 == 1 && e11 == 1 && i1 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        else if (c1 == 1 && e11 == 1 && g11 == 1)
        {
            g.drawImage(xImage, 300, 0, null);
            s = 1;
        }
        // check if player 2 wins
        else if (a1 == 2 && b1 == 2 && c1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (d1 == 2 && e11 == 2 && f1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (g11 == 2 && h1 == 2 && i1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (a1 == 2 && d1 == 2 && g11 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (b1 == 2 && e11 == 2 && h1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (c1 == 2 && f1 == 2 && i1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (a1 == 2 && e11 == 2 && i1 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        else if (c1 == 2 && e11 == 2 && g11 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 0, null);
            s = 2;
        }
        // check if computer wins
        else if (a1 == 2 && b1 == 2 && c1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (d1 == 2 && e11 == 2 && f1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (g11 == 2 && h1 == 2 && i1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (a1 == 2 && d1 == 2 && g11 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (b1 == 2 && e11 == 2 && h1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (c1 == 2 && f1 == 2 && i1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (a1 == 2 && e11 == 2 && i1 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (c1 == 2 && e11 == 2 && g11 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 0, null);
            s = 2;
        }
        else if (a1 != 0 && b1 != 0 && c1 != 0 && d1 != 0 && e11 != 0 && f1 != 0 && g11 != 0 && h1 != 0 && i1 != 0)
        {
            s = 3;
            g.drawImage(tieImage, 300, 0, null);
        }

        // big box t
        if (a2 == 1 && b2 == 1 && c2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (d2 == 1 && e2 == 1 && f2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (g2 == 1 && h2 == 1 && i2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (a2 == 1 && d2 == 1 && g2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (b2 == 1 && e2 == 1 && h2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (c2 == 1 && f2 == 1 && i2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (a2 == 1 && e2 == 1 && i2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        else if (c2 == 1 && e2 == 1 && g2 == 1)
        {
            g.drawImage(xImage, 600, 0, null);
            t = 1;
        }
        // check if player 2 wins
        else if (a2 == 2 && b2 == 2 && c2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (d2 == 2 && e2 == 2 && f2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (g2 == 2 && h2 == 2 && i2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (a2 == 2 && d2 == 2 && g2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (b2 == 2 && e2 == 2 && h2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (c2 == 2 && f2 == 2 && i2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (a2 == 2 && e2 == 2 && i2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        else if (c2 == 2 && e2 == 2 && g2 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 0, null);
            t = 2;
        }
        // check if computer wins
        else if (a2 == 2 && b2 == 2 && c2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (d2 == 2 && e2 == 2 && f2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (g2 == 2 && h2 == 2 && i2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (a2 == 2 && d2 == 2 && g2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (b2 == 2 && e2 == 2 && h2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (c2 == 2 && f2 == 2 && i2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (a2 == 2 && e2 == 2 && i2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (c2 == 2 && e2 == 2 && g2 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 0, null);
            t = 2;
        }
        else if (a2 != 0 && b2 != 0 && c2 != 0 && d2 != 0 && e2 != 0 && f2 != 0 && g2 != 0 && h2 != 0 && i2 != 0)
        {
            t = 3;
            g.drawImage(tieImage, 600, 0, null);
        }

        // big box u
        if (a3 == 1 && b3 == 1 && c3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (d3 == 1 && e3 == 1 && f3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (g3 == 1 && h3 == 1 && i3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (a3 == 1 && d3 == 1 && g3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (b3 == 1 && e3 == 1 && h3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (c3 == 1 && f3 == 1 && i3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (a3 == 1 && e3 == 1 && i3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        else if (c3 == 1 && e3 == 1 && g3 == 1)
        {
            g.drawImage(xImage, 0, 300, null);
            u = 1;
        }
        // check if player 2 wins
        else if (a3 == 2 && b3 == 2 && c3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (d3 == 2 && e3 == 2 && f3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (g3 == 2 && h3 == 2 && i3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (a3 == 2 && d3 == 2 && g3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (b3 == 2 && e3 == 2 && h3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (c3 == 2 && f3 == 2 && i3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (a3 == 2 && e3 == 2 && i3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        else if (c3 == 2 && e3 == 2 && g3 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 300, null);
            u = 2;
        }
        // check if computer wins
        else if (a3 == 2 && b3 == 2 && c3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (d3 == 2 && e3 == 2 && f3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (g3 == 2 && h3 == 2 && i3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (a3 == 2 && d3 == 2 && g3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (b3 == 2 && e3 == 2 && h3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (c3 == 2 && f3 == 2 && i3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (a3 == 2 && e3 == 2 && i3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (c3 == 2 && e3 == 2 && g3 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 300, null);
            u = 2;
        }
        else if (a3 != 0 && b3 != 0 && c3 != 0 && d3 != 0 && e3 != 0 && f3 != 0 && g3 != 0 && h3 != 0 && i3 != 0)
        {
            u = 3;
            g.drawImage(tieImage, 0, 300, null);
        }

        // big box v
        if (a4 == 1 && b4 == 1 && c4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (d4 == 1 && e4 == 1 && f4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (g4 == 1 && h4 == 1 && i4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (a4 == 1 && d4 == 1 && g4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (b4 == 1 && e4 == 1 && h4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (c4 == 1 && f4 == 1 && i4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (a4 == 1 && e4 == 1 && i4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        else if (c4 == 1 && e4 == 1 && g4 == 1)
        {
            g.drawImage(xImage, 300, 300, null);
            v = 1;
        }
        // check if player 2 wins
        else if (a4 == 2 && b4 == 2 && c4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (d4 == 2 && e4 == 2 && f4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (g4 == 2 && h4 == 2 && i4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (a4 == 2 && d4 == 2 && g4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (b4 == 2 && e4 == 2 && h4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (c4 == 2 && f4 == 2 && i4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (a4 == 2 && e4 == 2 && i4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        else if (c4 == 2 && e4 == 2 && g4 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 300, null);
            v = 2;
        }
        // check if computer wins
        else if (a4 == 2 && b4 == 2 && c4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (d4 == 2 && e4 == 2 && f4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (g4 == 2 && h4 == 2 && i4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (a4 == 2 && d4 == 2 && g4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (b4 == 2 && e4 == 2 && h4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (c4 == 2 && f4 == 2 && i4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (a4 == 2 && e4 == 2 && i4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (c4 == 2 && e4 == 2 && g4 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 300, null);
            v = 2;
        }
        else if (a4 != 0 && b4 != 0 && c4 != 0 && d4 != 0 && e4 != 0 && f4 != 0 && g4 != 0 && h4 != 0 && i4 != 0)
        {
            v = 3;
            g.drawImage(tieImage, 300, 300, null);
        }

        // big box w
        if (a5 == 1 && b5 == 1 && c5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (d5 == 1 && e5 == 1 && f5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (g5 == 1 && h5 == 1 && i5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (a5 == 1 && d5 == 1 && g5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (b5 == 1 && e5 == 1 && h5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (c5 == 1 && f5 == 1 && i5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (a5 == 1 && e5 == 1 && i5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        else if (c5 == 1 && e5 == 1 && g5 == 1)
        {
            g.drawImage(xImage, 600, 300, null);
            w = 1;
        }
        // check if player 2 wins
        else if (a5 == 2 && b5 == 2 && c5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (d5 == 2 && e5 == 2 && f5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (g5 == 2 && h5 == 2 && i5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (a5 == 2 && d5 == 2 && g5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (b5 == 2 && e5 == 2 && h5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (c5 == 2 && f5 == 2 && i5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (a5 == 2 && e5 == 2 && i5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        else if (c5 == 2 && e5 == 2 && g5 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 300, null);
            w = 2;
        }
        // check if computer wins
        else if (a5 == 2 && b5 == 2 && c5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (d5 == 2 && e5 == 2 && f5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (g5 == 2 && h5 == 2 && i5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (a5 == 2 && d5 == 2 && g5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (b5 == 2 && e5 == 2 && h5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (c5 == 2 && f5 == 2 && i5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (a5 == 2 && e5 == 2 && i5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (c5 == 2 && e5 == 2 && g5 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 300, null);
            w = 2;
        }
        else if (a5 != 0 && b5 != 0 && c5 != 0 && d5 != 0 && e5 != 0 && f5 != 0 && g5 != 0 && h5 != 0 && i5 != 0)
        {
            w = 3;
            g.drawImage(tieImage, 600, 300, null);
        }

        // big box x1
        if (a6 == 1 && b6 == 1 && c6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (d6 == 1 && e6 == 1 && f6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (g6 == 1 && h6 == 1 && i6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (a6 == 1 && d6 == 1 && g6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (b6 == 1 && e6 == 1 && h6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (c6 == 1 && f6 == 1 && i6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (a6 == 1 && e6 == 1 && i6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        else if (c6 == 1 && e6 == 1 && g6 == 1)
        {
            g.drawImage(xImage, 0, 600, null);
            x1 = 1;
        }
        // check if player 2 wins
        else if (a6 == 2 && b6 == 2 && c6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (d6 == 2 && e6 == 2 && f6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (g6 == 2 && h6 == 2 && i6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (a6 == 2 && d6 == 2 && g6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (b6 == 2 && e6 == 2 && h6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (c6 == 2 && f6 == 2 && i6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (a6 == 2 && e6 == 2 && i6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        else if (c6 == 2 && e6 == 2 && g6 == 2 && players == 2)
        {
            g.drawImage(oImage, 0, 600, null);
            x1 = 2;
        }
        // check if computer wins
        else if (a6 == 2 && b6 == 2 && c6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (d6 == 2 && e6 == 2 && f6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (g6 == 2 && h6 == 2 && i6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (a6 == 2 && d6 == 2 && g6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (b6 == 2 && e6 == 2 && h6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (c6 == 2 && f6 == 2 && i6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (a6 == 2 && e6 == 2 && i6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (c6 == 2 && e6 == 2 && g6 == 2 && players == 1)
        {
            g.drawImage(cImage, 0, 600, null);
            x1 = 2;
        }
        else if (a6 != 0 && b6 != 0 && c6 != 0 && d6 != 0 && e6 != 0 && f6 != 0 && g6 != 0 && h6 != 0 && i6 != 0)
        {
            x1 = 3;
            g.drawImage(tieImage, 0, 600, null);
        }

        // big box y
        if (a7 == 1 && b7 == 1 && c7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (d7 == 1 && e7 == 1 && f7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (g7 == 1 && h7 == 1 && i7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (a7 == 1 && d7 == 1 && g7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (b7 == 1 && e7 == 1 && h7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (c7 == 1 && f7 == 1 && i7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (a7 == 1 && e7 == 1 && i7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        else if (c7 == 1 && e7 == 1 && g7 == 1)
        {
            g.drawImage(xImage, 300, 600, null);
            y1 = 1;
        }
        // check if player 2 wins
        else if (a7 == 2 && b7 == 2 && c7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (d7 == 2 && e7 == 2 && f7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (g7 == 2 && h7 == 2 && i7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (a7 == 2 && d7 == 2 && g7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (b7 == 2 && e7 == 2 && h7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (c7 == 2 && f7 == 2 && i7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (a7 == 2 && e7 == 2 && i7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        else if (c7 == 2 && e7 == 2 && g7 == 2 && players == 2)
        {
            g.drawImage(oImage, 300, 600, null);
            y1 = 2;
        }
        // check if computer wins
        else if (a7 == 2 && b7 == 2 && c7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (d7 == 2 && e7 == 2 && f7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (g7 == 2 && h7 == 2 && i7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (a7 == 2 && d7 == 2 && g7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (b7 == 2 && e7 == 2 && h7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (c7 == 2 && f7 == 2 && i7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (a7 == 2 && e7 == 2 && i7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (c7 == 2 && e7 == 2 && g7 == 2 && players == 1)
        {
            g.drawImage(cImage, 300, 600, null);
            y1 = 2;
        }
        else if (a7 != 0 && b7 != 0 && c7 != 0 && d7 != 0 && e7 != 0 && f7 != 0 && g7 != 0 && h7 != 0 && i7 != 0)
        {
            y1 = 3;
            g.drawImage(tieImage, 300, 600, null);
        }

        // big box z
        if (a8 == 1 && b8 == 1 && c8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (d8 == 1 && e8 == 1 && f8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (g8 == 1 && h8 == 1 && i8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (a8 == 1 && d8 == 1 && g8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (b8 == 1 && e8 == 1 && h8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (c8 == 1 && f8 == 1 && i8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (a8 == 1 && e8 == 1 && i8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        else if (c8 == 1 && e8 == 1 && g8 == 1)
        {
            g.drawImage(xImage, 600, 600, null);
            z = 1;
        }
        // check if player 2 wins
        else if (a8 == 2 && b8 == 2 && c8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (d8 == 2 && e8 == 2 && f8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (g8 == 2 && h8 == 2 && i8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (a8 == 2 && d8 == 2 && g8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (b8 == 2 && e8 == 2 && h8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (c8 == 2 && f8 == 2 && i8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (a8 == 2 && e8 == 2 && i8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        else if (c8 == 2 && e8 == 2 && g8 == 2 && players == 2)
        {
            g.drawImage(oImage, 600, 600, null);
            z = 2;
        }
        // check computer wins
        else if (a8 == 2 && b8 == 2 && c8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (d8 == 2 && e8 == 2 && f8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (g8 == 2 && h8 == 2 && i8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (a8 == 2 && d8 == 2 && g8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (b8 == 2 && e8 == 2 && h8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (c8 == 2 && f8 == 2 && i8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (a8 == 2 && e8 == 2 && i8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (c8 == 2 && e8 == 2 && g8 == 2 && players == 1)
        {
            g.drawImage(cImage, 600, 600, null);
            z = 2;
        }
        else if (a8 != 0 && b8 != 0 && c8 != 0 && d8 != 0 && e8 != 0 && f8 != 0 && g8 != 0 && h8 != 0 && i8 != 0)
        {
            z = 3;
            g.drawImage(tieImage, 600, 600, null);
        }

        if (players == 2)
            checkWinnerHard();
        else
            checkWinnerHard2();
    }

    public void drawXWin(Graphics g)
    {
        g.drawImage(xWin, 0, 0, null);
        //play again button
        g.setColor(Color.white);
        g.drawRect(270, 612, 360, 75);
    }

    public void drawOWin(Graphics g)
    {
        g.drawImage(oWin, 0, 0, null);
        //play again button
        g.setColor(Color.white);
        g.drawRect(270, 612, 360, 75);
    }

    public void drawTie(Graphics g)
    {
        g.drawImage(Tie, 0, 0, null);
        //play again button
        g.setColor(Color.white);
        g.drawRect(270, 612, 360, 75);
    }

    public void drawCWin(Graphics g)// special computer image
    {
        g.drawImage(cWin, 0, 0, null);
        //play again button
        g.setColor(Color.white);
        g.drawRect(270, 612, 360, 75);
    }

    public void checkWinner()
    {
        // check if player 1 wins
        if (a == 1 && b == 1 && c == 1)
            screen = 3;
        else if (d == 1 && e1 == 1 && f == 1)
            screen = 3; 
        else if (g1 == 1 && h == 1 && i == 1)
            screen = 3;
        else if (a == 1 && d == 1 && g1 == 1)
            screen = 3;
        else if (b == 1 && e1 == 1 && h == 1)
            screen = 3;
        else if ( c == 1 && f == 1 && i == 1)
            screen = 3;
        else if (a == 1 && e1 == 1 && i == 1)
            screen = 3;
        else if (c == 1 && e1 == 1 && g1 == 1)
            screen = 3;

        // check if player 2 wins
        else if (a == 2 && b == 2 && c == 2)
            screen = 4;
        else if (d == 2 && e1 == 2 && f == 2)
            screen = 4; 
        else if (g1 == 2 && h == 2 && i == 2)
            screen = 4;
        else if (a == 2 && d == 2 && g1 == 2)
            screen = 4;
        else if (b == 2 && e1 == 2 && h == 2)
            screen = 4;
        else if ( c == 2 && f == 2 && i == 2)
            screen = 4;
        else if (a == 2 && e1 == 2 && i == 2)
            screen = 4;
        else if (c == 2 && e1 == 2 && g1 == 2)
            screen = 4;

        // check for tie
        else if(a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0)
            screen = 5;

        repaint();
    }

    public void checkWinner2() // this is for the one player mode
    {
        // check if player 1 wins
        if (a == 1 && b == 1 && c == 1)
            screen = 3;
        else if (d == 1 && e1 == 1 && f == 1)
            screen = 3; 
        else if (g1 == 1 && h == 1 && i == 1)
            screen = 3;
        else if (a == 1 && d == 1 && g1 == 1)
            screen = 3;
        else if (b == 1 && e1 == 1 && h == 1)
            screen = 3;
        else if ( c == 1 && f == 1 && i == 1)
            screen = 3;
        else if (a == 1 && e1 == 1 && i == 1)
            screen = 3;
        else if (c == 1 && e1 == 1 && g1 == 1)
            screen = 3;

        // check if computer wins
        else if (a == 2 && b == 2 && c == 2)
            screen = 6;
        else if (d == 2 && e1 == 2 && f == 2)
            screen = 6; 
        else if (g1 == 2 && h == 2 && i == 2)
            screen = 6;
        else if (a == 2 && d == 2 && g1 == 2)
            screen = 6;
        else if (b == 2 && e1 == 2 && h == 2)
            screen = 6;
        else if ( c == 2 && f == 2 && i == 2)
            screen = 6;
        else if (a == 2 && e1 == 2 && i == 2)
            screen = 6;
        else if (c == 2 && e1 == 2 && g1 == 2)
            screen = 6;

        // check for tie
        else if(a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0)
            screen = 5;

        repaint();
    }

    public void checkWinnerMed() // 4x4 board
    {
        // check if player 1 wins
        if (a == 1 && b == 1 && c == 1 && d == 1)
            screen = 3;
        else if (e1 == 1 && f == 1 && g1 == 1 && h == 1)
            screen = 3; 
        else if (i == 1 && j == 1 && k == 1 && l == 1)
            screen = 3;
        else if (m == 1 && n == 1 && o == 1 && p == 1)
            screen = 3;
        else if (a == 1 && e1 == 1 && i == 1 && m == 1)
            screen = 3;
        else if (b == 1 && f == 1 && j == 1 && n == 1)
            screen = 3;
        else if (c == 1 && g1 == 1 && k == 1 && o == 1)
            screen = 3;
        else if (d == 1 && h == 1 && l == 1 && p == 1)
            screen = 3;
        else if (a == 1 && f == 1 && k == 1 && p == 1)
            screen = 3;
        else if (d == 1 && g1 == 1 && j == 1 && m == 1)
            screen = 3;

        // check if player 2 wins
        else if (a == 2 && b == 2 && c == 2 && d == 2)
            screen = 4;
        else if (e1 == 2 && f == 2 && g1 == 2 && h == 2)
            screen = 4; 
        else if (i == 2 && j == 2 && k == 2 && l == 2)
            screen = 4;
        else if (m == 2 && n == 2 && o == 2 && p == 2)
            screen = 4;
        else if (a == 2 && e1 == 2 && i == 2 && m == 2)
            screen = 4;
        else if (b == 2 && f == 2 && j == 2 && n == 2)
            screen = 4;
        else if (c == 2 && g1 == 2 && k == 2 && o == 2)
            screen = 4;
        else if (d == 2 && h == 2 && l == 2 && p == 2)
            screen = 4;
        else if (a == 2 && f == 2 && k == 2 && p == 2)
            screen = 4;
        else if (d == 2 && g1 == 2 && j == 2 && m == 2)
            screen = 4;

        // check for tie
        else if(a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0 && j != 0 && k != 0 && l != 0 && m != 0 && n != 0 && o != 0 && p != 0)
            screen = 5;

        repaint();
    }

    public void checkWinnerMed2() // 4x4 board - one player
    {
        // check if player 1 wins
        if (a == 1 && b == 1 && c == 1 && d == 1)
            screen = 3;
        else if (e1 == 1 && f == 1 && g1 == 1 && h == 1)
            screen = 3; 
        else if (i == 1 && j == 1 && k == 1 && l == 1)
            screen = 3;
        else if (m == 1 && n == 1 && o == 1 && p == 1)
            screen = 3;
        else if (a == 1 && e1 == 1 && i == 1 && m == 1)
            screen = 3;
        else if (b == 1 && f == 1 && j == 1 && n == 1)
            screen = 3;
        else if (c == 1 && g1 == 1 && k == 1 && o == 1)
            screen = 3;
        else if (d == 1 && h == 1 && l == 1 && p == 1)
            screen = 3;
        else if (a == 1 && f == 1 && k == 1 && p == 1)
            screen = 3;
        else if (d == 1 && g1 == 1 && j == 1 && m == 1)
            screen = 3;

        // check if computer wins
        else if (a == 2 && b == 2 && c == 2 && d == 2)
            screen = 6;
        else if (e1 == 2 && f == 2 && g1 == 2 && h == 2)
            screen = 6; 
        else if (i == 2 && j == 2 && k == 2 && l == 2)
            screen = 6;
        else if (m == 2 && n == 2 && o == 2 && p == 2)
            screen = 6;
        else if (a == 2 && e1 == 2 && i == 2 && m == 2)
            screen = 6;
        else if (b == 2 && f == 2 && j == 2 && n == 2)
            screen = 6;
        else if (c == 2 && g1 == 2 && k == 2 && o == 2)
            screen = 6;
        else if (d == 2 && h == 2 && l == 2 && p == 2)
            screen = 6;
        else if (a == 2 && f == 2 && k == 2 && p == 2)
            screen = 6;
        else if (d == 2 && g1 == 2 && j == 2 && m == 2)
            screen = 6;

        // check for tie
        else if(a != 0 && b != 0 && c != 0 && d != 0 && e1 != 0 && f != 0 && g1 != 0 && h != 0 && i != 0 && j != 0 && k != 0 && l != 0 && m != 0 && n != 0 && o != 0 && p != 0)
            screen = 5;

        repaint();
    }

    public void checkWinnerHard() // big board
    {
        // check if player 1 wins
        if (r == 1 && s == 1 && t == 1)
            screen = 3;
        else if (u == 1 && v == 1 && w == 1)
            screen = 3; 
        else if (x1 == 1 && y1 == 1 && z == 1)
            screen = 3;
        else if (r == 1 && u == 1 && x1 == 1)
            screen = 3;
        else if (s == 1 && v == 1 && y1 == 1)
            screen = 3;
        else if (t == 1 && w == 1 && z == 1)
            screen = 3;
        else if (r == 1 && v == 1 && z == 1)
            screen = 3;
        else if (t == 1 && v == 1 && x1 == 1)
            screen = 3;

        // check if player 2 wins
        else if (r == 2 && s == 2 && t == 2)
            screen = 4;
        else if (u == 2 && v == 2 && w == 2)
            screen = 4; 
        else if (x1 == 2 && y1 == 2 && z == 2)
            screen = 4;
        else if (r == 2 && u == 2 && x1 == 2)
            screen = 4;
        else if (s == 2 && v == 2 && y1 == 2)
            screen = 4;
        else if (t == 2 && w == 2 && z == 2)
            screen = 4;
        else if (r == 2 && v == 2 && z == 2)
            screen = 4;
        else if (t == 2 && v == 2 && x1 == 2)
            screen = 4;

        // check for tie
        else if(r != 0 && s != 0 && t != 0 && u != 0 && v != 0 && w != 0 && x1 != 0 && y1 != 0 && z != 0)
            screen = 5;

        repaint();
    }

    public void checkWinnerHard2() // hard board - one player
    {
        // check if player 1 wins
        if (r == 1 && s == 1 && t == 1)
            screen = 3;
        else if (u == 1 && v == 1 && w == 1)
            screen = 3; 
        else if (x1 == 1 && y1 == 1 && z == 1)
            screen = 3;
        else if (r == 1 && u == 1 && x1 == 1)
            screen = 3;
        else if (s == 1 && v == 1 && y1 == 1)
            screen = 3;
        else if (t == 1 && w == 1 && z == 1)
            screen = 3;
        else if (r == 1 && v == 1 && z == 1)
            screen = 3;
        else if (t == 1 && v == 1 && x1 == 1)
            screen = 3;

        // check if computer wins
        else if (r == 2 && s == 2 && t == 2)
            screen = 6;
        else if (u == 2 && v == 2 && w == 2)
            screen = 6; 
        else if (x1 == 2 && y1 == 2 && z == 2)
            screen = 6;
        else if (r == 2 && u == 2 && x1 == 2)
            screen = 6;
        else if (s == 2 && v == 2 && y1 == 2)
            screen = 6;
        else if (t == 2 && w == 2 && z == 2)
            screen = 6;
        else if (r == 2 && v == 2 && z == 2)
            screen = 6;
        else if (t == 2 && v == 2 && x1 == 2)
            screen = 6;

        // check for tie
        else if(r != 0 && s != 0 && t != 0 && u != 0 && v != 0 && w != 0 && x1 != 0 && y1 != 0 && z != 0)
            screen = 5;

        repaint();
    }

    public void delay(int amount) // delay for win screen
    {
        for (int i = 1; i <= amount; i++)
            System.out.println(i);
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();

        if (screen == 1) // on the title screen
        {
            if (x >= 500 && x <= 800 && y >= 600 && y <= 700) // 2 player button
            {
                screen = 7;
                players = 2;
            }
            else if (x >= 100 && x <= 400 && y >= 600 && y <= 700) // 1 player button
            {
                screen = 7;
                players = 1;
            }
        }
        else if (screen == 7) // choose a mode screen
        {
            if (x >= 50 && x <= 200 && y >= 500 && y <= 600) // 3x3 board
            {
                screen = 2;
            }
            if (x >= 375 && x <= 525 && y >= 500 && y <= 600) // 4x4 board
            {
                screen = 8; 
            }
            if (x >= 700 && x <= 850 && y >= 500 && y <= 600) // hard board
            {
                screen = 9; 
            }
        }
        else if (screen == 2 && players == 2) // on the 3x3 board and 2 players mode
        {
            if (x <= 300 && y <= 300 && a == 0) // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
                else 
                {
                    a = 2;
                    turn = 1;
                }
            }
            if (x > 300 && x <= 600 && y <= 300 && b == 0) //b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
                else 
                {
                    b = 2;
                    turn = 1;
                }  
            }
            if (x > 600 && y <= 300 && c == 0) // c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
                else 
                {
                    c = 2;
                    turn = 1;
                }  
            }
            if (x <= 300 && y > 300 && y <= 600 && d == 0) // d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
                else 
                {
                    d = 2;
                    turn = 1;
                }  
            }
            if (x > 300 && x <= 600 && y > 300 && y <= 600 && e1 == 0) // e1
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
                else 
                {
                    e1 = 2;
                    turn = 1;
                }   
            }
            if (x > 600 && y > 300 && y <= 600 && f == 0) // f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
                else 
                {
                    f = 2;
                    turn = 1;
                }     
            }
            if (x <= 300 && y > 600 && g1 == 0) // g1
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
                else 
                {
                    g1 = 2;
                    turn = 1;
                }       
            }
            if (x > 300 && x <= 600 && y > 600 && h == 0) //h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
                else 
                {
                    h = 2;
                    turn = 1;
                }       
            }
            if (x > 600 && y > 600 && i == 0) // i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
                else 
                {
                    i = 2;
                    turn = 1;
                }       
            }
        }
        else if (screen == 8 && players == 2) // on the 4x4 board and 2 players mode
        {
            if (x <= 225 && y <= 225 && a == 0) // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
                else 
                {
                    a = 2;
                    turn = 1;
                }
            }
            if (x > 225 && x <= 450 && y <= 225 && b == 0) //b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
                else 
                {
                    b = 2;
                    turn = 1;
                }  
            }
            if (x > 450 && x <= 675 && y <= 225 && c == 0) // c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
                else 
                {
                    c = 2;
                    turn = 1;
                }  
            }
            if (x > 675 && y <= 225 && d == 0) // d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
                else 
                {
                    d = 2;
                    turn = 1;
                }  
            }
            if (x <= 225 && y > 225 && y <= 450 && e1 == 0) // e1
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
                else 
                {
                    e1 = 2;
                    turn = 1;
                }   
            }
            if (x > 225 && x <= 450 && y > 225 && y <= 450 && f == 0) // f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
                else 
                {
                    f = 2;
                    turn = 1;
                }     
            }
            if (x > 450 && x <= 675 && y > 225 && y <= 450 && g1 == 0) // g1
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
                else 
                {
                    g1 = 2;
                    turn = 1;
                }       
            }
            if (x > 675 && y <= 450 && y > 225 && h == 0) //h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
                else 
                {
                    h = 2;
                    turn = 1;
                }       
            }
            if (x <= 225 && y > 450 && y <= 675 && i == 0) // i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
                else 
                {
                    i = 2;
                    turn = 1;
                }       
            }
            if (x > 225 && x <= 450 && y > 450 && y <= 675 && j == 0) // j
            {
                if (turn == 1)
                {
                    j = 1;
                    turn = 2;
                }
                else 
                {
                    j = 2;
                    turn = 1;
                }     
            }
            if (x > 450 && x <= 675 && y > 450 && y <= 675 && k == 0) // k
            {
                if (turn == 1)
                {
                    k = 1;
                    turn = 2;
                }
                else 
                {
                    k = 2;
                    turn = 1;
                }     
            }
            if (x > 675 && y > 450 && y <= 675 && l == 0) // l
            {
                if (turn == 1)
                {
                    l = 1;
                    turn = 2;
                }
                else 
                {
                    l = 2;
                    turn = 1;
                }     
            }
            if (x <= 225 && y > 675 && m == 0) // m
            {
                if (turn == 1)
                {
                    m = 1;
                    turn = 2;
                }
                else 
                {
                    m = 2;
                    turn = 1;
                }     
            }
            if (x > 225 && x <= 450 && y > 675 && n == 0) // n
            {
                if (turn == 1)
                {
                    n = 1;
                    turn = 2;
                }
                else 
                {
                    n = 2;
                    turn = 1;
                }     
            }
            if (x > 450 && x <= 675 && y > 675 && o == 0) // o
            {
                if (turn == 1)
                {
                    o = 1;
                    turn = 2;
                }
                else 
                {
                    o = 2;
                    turn = 1;
                }     
            }
            if (x > 675 && y > 675 && p == 0) // p
            {
                if (turn == 1)
                {
                    p = 1;
                    turn = 2;
                }
                else 
                {
                    p = 2;
                    turn = 1;
                }     
            }
        }
        else if (screen == 9 && players == 2) // on the hard board and 2 players mode
        {
            // in big box r
            if (r == 0)
            {
                if (x <= 100 && y <= 100 && a == 0) // clicked on box a
                {
                    if (turn == 1)
                    {
                        a = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a = 2;
                        turn = 1;
                    }
                }
                if (x > 100 && x <= 200 && y <= 100 && b == 0) //b
                {
                    if (turn == 1)
                    {
                        b = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b = 2;
                        turn = 1;
                    }  
                }
                if (x > 200 && x <= 300 && y <= 100 && c == 0) // c
                {
                    if (turn == 1)
                    {
                        c = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c = 2;
                        turn = 1;
                    }  
                }
                if (x <= 100 && y > 100 && y <= 200 && d == 0) // d
                {
                    if (turn == 1)
                    {
                        d = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d = 2;
                        turn = 1;
                    }  
                }
                if (x > 100 && x <= 200 && y > 100 && y <= 200 && e1 == 0) // e1
                {
                    if (turn == 1)
                    {
                        e1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e1 = 2;
                        turn = 1;
                    }   
                }
                if (x > 200 && x <= 300 && y > 100 && y <= 200 && f == 0) // f
                {
                    if (turn == 1)
                    {
                        f = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f = 2;
                        turn = 1;
                    }     
                }
                if (x <= 100 && y > 200 && y <= 300 && g1 == 0) // g1
                {
                    if (turn == 1)
                    {
                        g1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g1 = 2;
                        turn = 1;
                    }       
                }
                if (x > 100 && x <= 200 && y <= 300 && y > 200 && h == 0) //h
                {
                    if (turn == 1)
                    {
                        h = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h = 2;
                        turn = 1;
                    }       
                }
                if (x <= 300 && x > 200 && y > 200 && y <= 300 && i == 0) // i
                {
                    if (turn == 1)
                    {
                        i = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i = 2;
                        turn = 1;
                    }       
                }
            }
            //in big box s
            if (s == 0)
            {
                if (x <= 400 && x > 300 && y <= 100 && a1 == 0) // clicked on box a1
                {
                    if (turn == 1)
                    {
                        a1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a1 = 2;
                        turn = 1;
                    }
                }
                if (x > 400 && x <= 500 && y <= 100 && b1 == 0) //b1
                {
                    if (turn == 1)
                    {
                        b1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b1 = 2;
                        turn = 1;
                    }  
                }
                if (x > 500 && x <= 600 && y <= 100 && c1 == 0) // c1
                {
                    if (turn == 1)
                    {
                        c1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c1 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 400 && x > 300 && y > 100 && y <= 200 && d1 == 0) // d1
                {
                    if (turn == 1)
                    {
                        d1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d1 = 2;
                        turn = 1;
                    }  
                }
                if (x > 400 && x <= 500 && y > 100 && y <= 200 && e11 == 0) // e11
                {
                    if (turn == 1)
                    {
                        e11 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e11 = 2;
                        turn = 1;
                    }   
                }
                if (x > 500 && x <= 600 && y > 100 && y <= 200 && f1 == 0) // f1
                {
                    if (turn == 1)
                    {
                        f1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f1 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 400 && x > 300 && y > 200 && y <= 300 && g11 == 0) // g11
                {
                    if (turn == 1)
                    {
                        g11 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g11 = 2;
                        turn = 1;
                    }       
                }
                if (x > 400 && x <= 500 && y <= 300 && y > 200 && h1 == 0) //h1
                {
                    if (turn == 1)
                    {
                        h1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h1 = 2;
                        turn = 1;
                    }       
                }
                if (x <= 600 && x > 500 && y > 200 && y <= 300 && i1 == 0) // i1
                {
                    if (turn == 1)
                    {
                        i1 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i1 = 2;
                        turn = 1;
                    }       
                }
            }
            //in big box t
            if (t == 0)
            {
                if (x <= 700 && x > 600 && y <= 100 && a2 == 0) // clicked on box a2
                {
                    if (turn == 1)
                    {
                        a2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a2 = 2;
                        turn = 1;
                    }
                }
                if (x > 700 && x <= 800 && y <= 100 && b2 == 0) //b2
                {
                    if (turn == 1)
                    {
                        b2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b2 = 2;
                        turn = 1;
                    }  
                }
                if (x > 800 && y <= 100 && c2 == 0) // c2
                {
                    if (turn == 1)
                    {
                        c2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c2 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 700 && x > 600 && y > 100 && y <= 200 && d2 == 0) // d2
                {
                    if (turn == 1)
                    {
                        d2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d2 = 2;
                        turn = 1;
                    }  
                }
                if (x > 700 && x <= 800 && y > 100 && y <= 200 && e2 == 0) // e2
                {
                    if (turn == 1)
                    {
                        e2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e2 = 2;
                        turn = 1;
                    }   
                }
                if (x > 800 && y > 100 && y <= 200 && f2 == 0) // f2
                {
                    if (turn == 1)
                    {
                        f2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f2 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 700 && x > 600 && y > 200 && y <= 300 && g2 == 0) // g2
                {
                    if (turn == 1)
                    {
                        g2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g2 = 2;
                        turn = 1;
                    }       
                }
                if (x > 700 && x <= 800 && y <= 300 && y > 200 && h2 == 0) //h2
                {
                    if (turn == 1)
                    {
                        h2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h2 = 2;
                        turn = 1;
                    }       
                }
                if (x > 800 && y > 200 && y <= 300 && i2 == 0) // i2
                {
                    if (turn == 1)
                    {
                        i2 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i2 = 2;
                        turn = 1;
                    }       
                }
            }
            // in big box u
            if (u == 0)
            {
                if (x <= 100 && y > 300 && y <= 400 && a3 == 0) // clicked on box a3
                {
                    if (turn == 1)
                    {
                        a3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a3 = 2;
                        turn = 1;
                    }
                }
                if (x > 100 && x <= 200 && y <= 400 && y > 300 && b3 == 0) //b3
                {
                    if (turn == 1)
                    {
                        b3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b3 = 2;
                        turn = 1;
                    }  
                }
                if (x > 200 && x <= 300 && y <= 400 && y > 300 && c3 == 0) // c3
                {
                    if (turn == 1)
                    {
                        c3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c3 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 100 && y > 400 && y <= 500 && d3 == 0) // d3
                {
                    if (turn == 1)
                    {
                        d3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d3 = 2;
                        turn = 1;
                    }  
                }
                if (x > 100 && x <= 200 && y > 400 && y <= 500 && e3 == 0) // e3
                {
                    if (turn == 1)
                    {
                        e3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e3 = 2;
                        turn = 1;
                    }   
                }
                if (x > 200 && x <= 300 && y > 400 && y <= 500 && f3 == 0) // f3
                {
                    if (turn == 1)
                    {
                        f3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f3 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 100 && y > 200 && y <= 600 && y > 500 && g3 == 0) // g3
                {
                    if (turn == 1)
                    {
                        g3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g3 = 2;
                        turn = 1;
                    }       
                }
                if (x > 100 && x <= 200 && y <= 600 && y > 500 && h3 == 0) //h3
                {
                    if (turn == 1)
                    {
                        h3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h3 = 2;
                        turn = 1;
                    }       
                }
                if (x <= 300 && x > 200 && y > 500 && y <= 600 && i3 == 0) // i3
                {
                    if (turn == 1)
                    {
                        i3 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i3 = 2;
                        turn = 1;
                    }       
                }
            }
            //in big box v
            if (v == 0)
            {
                if (x <= 400 && x > 300 && y <= 400 && y > 300 && a4 == 0) // clicked on box a4
                {
                    if (turn == 1)
                    {
                        a4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a4 = 2;
                        turn = 1;
                    }
                }
                if (x > 400 && x <= 500 && y <= 400 && y > 300 && b4 == 0) //b4
                {
                    if (turn == 1)
                    {
                        b4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b4 = 2;
                        turn = 1;
                    }  
                }
                if (x > 500 && x <= 600 && y <= 400 && y > 300 && c4 == 0) // c4
                {
                    if (turn == 1)
                    {
                        c4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c4 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 400 && x > 300 && y > 400 && y <= 500 && d4 == 0) // d4
                {
                    if (turn == 1)
                    {
                        d4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d4 = 2;
                        turn = 1;
                    }  
                }
                if (x > 400 && x <= 500 && y > 400 && y <= 500 && e4 == 0) // e4
                {
                    if (turn == 1)
                    {
                        e4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e4 = 2;
                        turn = 1;
                    }   
                }
                if (x > 500 && x <= 600 && y > 400 && y <= 500 && f4 == 0) // f4
                {
                    if (turn == 1)
                    {
                        f4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f4 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 400 && x > 300 && y > 500 && y <= 600 && g4 == 0) // g4
                {
                    if (turn == 1)
                    {
                        g4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g4 = 2;
                        turn = 1;
                    }       
                }
                if (x > 400 && x <= 500 && y <= 600 && y > 500 && h4 == 0) //h4
                {
                    if (turn == 1)
                    {
                        h4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h4 = 2;
                        turn = 1;
                    }       
                }
                if (x <= 600 && x > 500 && y > 500 && y <= 600 && i4 == 0) // i4
                {
                    if (turn == 1)
                    {
                        i4 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i4 = 2;
                        turn = 1;
                    }       
                }
            }
            //in big box w
            if (w == 0)
            {
                if (x <= 700 && x > 600 && y <= 400 && y > 300 && a5 == 0) // clicked on box a5
                {
                    if (turn == 1)
                    {
                        a5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a5 = 2;
                        turn = 1;
                    }
                }
                if (x > 700 && x <= 800 && y <= 400 && y > 300 && b5 == 0) //b5
                {
                    if (turn == 1)
                    {
                        b5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b5 = 2;
                        turn = 1;
                    }  
                }
                if (x > 800 && y <= 400 && y > 300 && c5 == 0) // c5
                {
                    if (turn == 1)
                    {
                        c5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c5 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 700 && x > 600 && y > 400 && y <= 500 && d5 == 0) // d5
                {
                    if (turn == 1)
                    {
                        d5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d5 = 2;
                        turn = 1;
                    }  
                }
                if (x > 700 && x <= 800 && y > 400 && y <= 500 && e5 == 0) // e5
                {
                    if (turn == 1)
                    {
                        e5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e5 = 2;
                        turn = 1;
                    }   
                }
                if (x > 800 && y > 400 && y <= 500 && f5 == 0) // f5
                {
                    if (turn == 1)
                    {
                        f5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f5 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 700 && x > 600 && y > 500 && y <= 600 && g5 == 0) // g5
                {
                    if (turn == 1)
                    {
                        g5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g5 = 2;
                        turn = 1;
                    }       
                }
                if (x > 700 && x <= 800 && y <= 600 && y > 500 && h5 == 0) //h5
                {
                    if (turn == 1)
                    {
                        h5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h5 = 2;
                        turn = 1;
                    }       
                }
                if (x > 800 && y > 500 && y <= 600 && i5 == 0) // i5
                {
                    if (turn == 1)
                    {
                        i5 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i5 = 2;
                        turn = 1;
                    }       
                }
            }
            // in big box x1
            if (x1 == 0)
            {
                if (x <= 100 && y > 600 && y <= 700 && a6 == 0) // clicked on box a6
                {
                    if (turn == 1)
                    {
                        a6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a6 = 2;
                        turn = 1;
                    }
                }
                if (x > 100 && x <= 200 && y <= 700 && y > 600 && b6 == 0) //b6
                {
                    if (turn == 1)
                    {
                        b6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b6 = 2;
                        turn = 1;
                    }  
                }
                if (x > 200 && x <= 300 && y <= 700 && y > 600 && c6 == 0) // c6
                {
                    if (turn == 1)
                    {
                        c6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c6 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 100 && y > 700 && y <= 800 && d6 == 0) // d6
                {
                    if (turn == 1)
                    {
                        d6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d6 = 2;
                        turn = 1;
                    }  
                }
                if (x > 100 && x <= 200 && y > 700 && y <= 800 && e6 == 0) // e6
                {
                    if (turn == 1)
                    {
                        e6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e6 = 2;
                        turn = 1;
                    }   
                }
                if (x > 200 && x <= 300 && y > 700 && y <= 800 && f6 == 0) // f6
                {
                    if (turn == 1)
                    {
                        f6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f6 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 100 && y > 800 && g6 == 0) // g6
                {
                    if (turn == 1)
                    {
                        g6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g6 = 2;
                        turn = 1;
                    }       
                }
                if (x > 100 && x <= 200 && y > 800 && h6 == 0) //h6
                {
                    if (turn == 1)
                    {
                        h6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h6 = 2;
                        turn = 1;
                    }       
                }
                if (x <= 300 && x > 200 && y > 800 && i6 == 0) // i6
                {
                    if (turn == 1)
                    {
                        i6 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i6 = 2;
                        turn = 1;
                    }       
                }
            }

            //in big box y1
            if (y1 == 0)
            {
                if (x <= 400 && x > 300 && y <= 700 && y > 600 && a7 == 0) // clicked on box a7
                {
                    if (turn == 1)
                    {
                        a7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a7 = 2;
                        turn = 1;
                    }
                }
                if (x > 400 && x <= 500 && y <= 700 && y > 600 && b7 == 0) //b7
                {
                    if (turn == 1)
                    {
                        b7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b7 = 2;
                        turn = 1;
                    }  
                }
                if (x > 500 && x <= 600 && y <= 700 && y > 600 && c7 == 0) // c7
                {
                    if (turn == 1)
                    {
                        c7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c7 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 400 && x > 300 && y > 700 && y <= 800 && d7 == 0) // d7
                {
                    if (turn == 1)
                    {
                        d7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d7 = 2;
                        turn = 1;
                    }  
                }
                if (x > 400 && x <= 500 && y > 700 && y <= 800 && e7 == 0) // e7
                {
                    if (turn == 1)
                    {
                        e7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e7 = 2;
                        turn = 1;
                    }   
                }
                if (x > 500 && x <= 600 && y > 700 && y <= 800 && f7 == 0) // f7
                {
                    if (turn == 1)
                    {
                        f7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f7 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 400 && x > 300 && y > 800 && g7 == 0) // g7
                {
                    if (turn == 1)
                    {
                        g7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g7 = 2;
                        turn = 1;
                    }       
                }
                if (x > 400 && x <= 500 && y > 800 && h7 == 0) //h7
                {
                    if (turn == 1)
                    {
                        h7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h7 = 2;
                        turn = 1;
                    }       
                }
                if (x <= 600 && x > 500 && y > 800 && i7 == 0) // i7
                {
                    if (turn == 1)
                    {
                        i7 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i7 = 2;
                        turn = 1;
                    }       
                }
            }

            //in big box z
            if (z == 0)
            {
                if (x <= 700 && x > 600 && y <= 700 && y > 600 && a8 == 0) // clicked on box a8
                {
                    if (turn == 1)
                    {
                        a8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        a8 = 2;
                        turn = 1;
                    }
                }
                if (x > 700 && x <= 800 && y <= 700 && y > 600 && b8 == 0) //b8
                {
                    if (turn == 1)
                    {
                        b8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        b8 = 2;
                        turn = 1;
                    }  
                }
                if (x > 800 && y <= 700 && y > 600 && c8 == 0) // c8
                {
                    if (turn == 1)
                    {
                        c8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        c8 = 2;
                        turn = 1;
                    }  
                }
                if (x <= 700 && x > 600 && y > 700 && y <= 800 && d8 == 0) // d8
                {
                    if (turn == 1)
                    {
                        d8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        d8 = 2;
                        turn = 1;
                    }  
                }
                if (x > 700 && x <= 800 && y > 700 && y <= 800 && e8 == 0) // e8
                {
                    if (turn == 1)
                    {
                        e8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        e8 = 2;
                        turn = 1;
                    }   
                }
                if (x > 800 && y > 700 && y <= 800 && f8 == 0) // f8
                {
                    if (turn == 1)
                    {
                        f8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        f8 = 2;
                        turn = 1;
                    }     
                }
                if (x <= 700 && x > 600 && y > 800 && g8 == 0) // g8
                {
                    if (turn == 1)
                    {
                        g8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        g8 = 2;
                        turn = 1;
                    }       
                }
                if (x > 700 && x <= 800 && y > 800 && h8 == 0) //h8
                {
                    if (turn == 1)
                    {
                        h8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        h8 = 2;
                        turn = 1;
                    }       
                }
                if (x > 800 && y > 800 && i8 == 0) // i8
                {
                    if (turn == 1)
                    {
                        i8 = 1;
                        turn = 2;
                    }
                    else 
                    {
                        i8 = 2;
                        turn = 1;
                    }       
                }
            }
        }
        else if (screen == 3 || screen == 4 || screen == 5 || screen == 6) // Play again button
        {
            if (x >= 270 && x <= 630 && y >= 612 && y <= 689)
            {
                screen = 1;
                // reset all variables
                a = 0;
                b = 0;
                c = 0;
                d = 0;
                e1 = 0;
                f = 0;
                g1 = 0;
                h = 0;
                i = 0;
                j = 0;
                k = 0;
                l = 0;
                m = 0;
                n = 0;
                o = 0;
                p = 0;
                a1 = 0;
                b1 = 0;
                c1 = 0;
                d1 = 0;
                e11 = 0;
                f1 = 0;
                g11 = 0;
                h1 = 0;
                i1 = 0;
                a2 = 0;
                b2 = 0;
                c2 = 0;
                d2 = 0;
                e2 = 0;
                f2 = 0;
                g2 = 0;
                h2 = 0;
                i2 = 0;
                a3 = 0;
                b3 = 0;
                c3 = 0;
                d3 = 0;
                e3 = 0;
                f3 = 0;
                g3 = 0;
                h3 = 0;
                i3 = 0;
                a4 = 0;
                b4 = 0;
                c4 = 0;
                d4 = 0;
                e4 = 0;
                f4 = 0;
                g4 = 0;
                h4 = 0;
                i4 = 0;
                a5 = 0;
                b5 = 0;
                c5 = 0;
                d5 = 0;
                e5 = 0;
                f5 = 0;
                g5 = 0;
                h5 = 0;
                i5 = 0;
                a6 = 0;
                b6 = 0;
                c6 = 0;
                d6 = 0;
                e6 = 0;
                f6 = 0;
                g6 = 0;
                h6 = 0;
                i6 = 0;
                a7 = 0;
                b7 = 0;
                c7 = 0;
                d7 = 0;
                e7 = 0;
                f7 = 0;
                g7 = 0;
                h7 = 0;
                i7 = 0;
                a8 = 0;
                b8 = 0;
                c8 = 0;
                d8 = 0;
                e8 = 0;
                f8 = 0;
                g8 = 0;
                h8 = 0;
                i8 = 0;
                r = 0; 
                s = 0;
                t = 0;
                u = 0;
                v = 0;
                w = 0;
                x = 0;
                y = 0;
                z = 0;

                turn = 1;
            }
        }

        else if (screen == 2 && players == 1) // on the 3x3 board and 1 player mode
        {
            if (x <= 300 && y <= 300 && a == 0) // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
            }
            if (x > 300 && x <= 600 && y <= 300 && b == 0) // b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
            }
            if (x > 600 && y <= 300 && c == 0) // c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
            }
            if (x <= 300 && y > 300 && y <= 600 && d == 0) // d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
            }
            if (x > 300 && x <= 600 && y > 300 && y <= 600 && e1 == 0) // e1
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }  
            }
            if (x > 600 && y > 300 && y <= 600 && f == 0) // f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }    
            }
            if (x <= 300 && y > 600 && g1 == 0) // g1
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }     
            }
            if (x > 300 && x <= 600 && y > 600 && h == 0) // h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }       
            }
            if (x > 600 && y > 600 && i == 0) // i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }      
            }
            computerMove();
        }
        else if (screen == 8 && players == 1) // on the 4x4 board and 1 player mode
        {
            if (x <= 225 && y <= 225 && a == 0) // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
            }
            if (x > 225 && x <= 450 && y <= 225 && b == 0) //b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                } 
            }
            if (x > 450 && x <= 675 && y <= 225 && c == 0) // c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
            }
            if (x > 675 && y <= 225 && d == 0) // d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
            }
            if (x <= 225 && y > 225 && y <= 450 && e1 == 0) // e1
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }  
            }
            if (x > 225 && x <= 450 && y > 225 && y <= 450 && f == 0) // f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }   
            }
            if (x > 450 && x <= 675 && y > 225 && y <= 450 && g1 == 0) // g1
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }     
            }
            if (x > 675 && y <= 450 && y > 225 && h == 0) //h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }      
            }
            if (x <= 225 && y > 450 && y <= 675 && i == 0) // i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }      
            }
            if (x > 225 && x <= 450 && y > 450 && y <= 675 && j == 0) // j
            {
                if (turn == 1)
                {
                    j = 1;
                    turn = 2;
                }   
            }
            if (x > 450 && x <= 675 && y > 450 && y <= 675 && k == 0) // k
            {
                if (turn == 1)
                {
                    k = 1;
                    turn = 2;
                }   
            }
            if (x > 675 && y > 450 && y <= 675 && l == 0) // l
            {
                if (turn == 1)
                {
                    l = 1;
                    turn = 2;
                }  
            }
            if (x <= 225 && y > 675 && m == 0) // m
            {
                if (turn == 1)
                {
                    m = 1;
                    turn = 2;
                }   
            }
            if (x > 225 && x <= 450 && y > 675 && n == 0) // n
            {
                if (turn == 1)
                {
                    n = 1;
                    turn = 2;
                }    
            }
            if (x > 450 && x <= 675 && y > 675 && o == 0) // o
            {
                if (turn == 1)
                {
                    o = 1;
                    turn = 2;
                }    
            }
            if (x > 675 && y > 675 && p == 0) // p
            {
                if (turn == 1)
                {
                    p = 1;
                    turn = 2;
                }   
            }
            computerMoveMed();
        }
        else if (screen == 9 && players == 1) // on the hard board and 1 player
        {
            // in big box r
            if (r == 0)
            {
                if (x <= 100 && y <= 100 && a == 0) // clicked on box a
                {
                    if (turn == 1)
                    {
                        a = 1;
                        turn = 2;
                    }
                }
                if (x > 100 && x <= 200 && y <= 100 && b == 0) //b
                {
                    if (turn == 1)
                    {
                        b = 1;
                        turn = 2;
                    }
                }
                if (x > 200 && x <= 300 && y <= 100 && c == 0) // c
                {
                    if (turn == 1)
                    {
                        c = 1;
                        turn = 2;
                    }
                }
                if (x <= 100 && y > 100 && y <= 200 && d == 0) // d
                {
                    if (turn == 1)
                    {
                        d = 1;
                        turn = 2;
                    }  
                }
                if (x > 100 && x <= 200 && y > 100 && y <= 200 && e1 == 0) // e1
                {
                    if (turn == 1)
                    {
                        e1 = 1;
                        turn = 2;
                    }  
                }
                if (x > 200 && x <= 300 && y > 100 && y <= 200 && f == 0) // f
                {
                    if (turn == 1)
                    {
                        f = 1;
                        turn = 2;
                    }   
                }
                if (x <= 100 && y > 200 && y <= 300 && g1 == 0) // g1
                {
                    if (turn == 1)
                    {
                        g1 = 1;
                        turn = 2;
                    }       
                }
                if (x > 100 && x <= 200 && y <= 300 && y > 200 && h == 0) //h
                {
                    if (turn == 1)
                    {
                        h = 1;
                        turn = 2;
                    }     
                }
                if (x <= 300 && x > 200 && y > 200 && y <= 300 && i == 0) // i
                {
                    if (turn == 1)
                    {
                        i = 1;
                        turn = 2;
                    }      
                }
            }
            //in big box s
            if (s == 0)
            {
                if (x <= 400 && x > 300 && y <= 100 && a1 == 0) // clicked on box a1
                {
                    if (turn == 1)
                    {
                        a1 = 1;
                        turn = 2;
                    }
                }
                if (x > 400 && x <= 500 && y <= 100 && b1 == 0) //b1
                {
                    if (turn == 1)
                    {
                        b1 = 1;
                        turn = 2;
                    }
                }
                if (x > 500 && x <= 600 && y <= 100 && c1 == 0) // c1
                {
                    if (turn == 1)
                    {
                        c1 = 1;
                        turn = 2;
                    } 
                }
                if (x <= 400 && x > 300 && y > 100 && y <= 200 && d1 == 0) // d1
                {
                    if (turn == 1)
                    {
                        d1 = 1;
                        turn = 2;
                    }
                }
                if (x > 400 && x <= 500 && y > 100 && y <= 200 && e11 == 0) // e11
                {
                    if (turn == 1)
                    {
                        e11 = 1;
                        turn = 2;
                    }   
                }
                if (x > 500 && x <= 600 && y > 100 && y <= 200 && f1 == 0) // f1
                {
                    if (turn == 1)
                    {
                        f1 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 400 && x > 300 && y > 200 && y <= 300 && g11 == 0) // g11
                {
                    if (turn == 1)
                    {
                        g11 = 1;
                        turn = 2;
                    }      
                }
                if (x > 400 && x <= 500 && y <= 300 && y > 200 && h1 == 0) //h1
                {
                    if (turn == 1)
                    {
                        h1 = 1;
                        turn = 2;
                    }       
                }
                if (x <= 600 && x > 500 && y > 200 && y <= 300 && i1 == 0) // i1
                {
                    if (turn == 1)
                    {
                        i1 = 1;
                        turn = 2;
                    }    
                }
            }
            //in big box t
            if (t == 0)
            {
                if (x <= 700 && x > 600 && y <= 100 && a2 == 0) // clicked on box a2
                {
                    if (turn == 1)
                    {
                        a2 = 1;
                        turn = 2;
                    }
                }
                if (x > 700 && x <= 800 && y <= 100 && b2 == 0) //b2
                {
                    if (turn == 1)
                    {
                        b2 = 1;
                        turn = 2;
                    }  
                }
                if (x > 800 && y <= 100 && c2 == 0) // c2
                {
                    if (turn == 1)
                    {
                        c2 = 1;
                        turn = 2;
                    } 
                }
                if (x <= 700 && x > 600 && y > 100 && y <= 200 && d2 == 0) // d2
                {
                    if (turn == 1)
                    {
                        d2 = 1;
                        turn = 2;
                    }
                }
                if (x > 700 && x <= 800 && y > 100 && y <= 200 && e2 == 0) // e2
                {
                    if (turn == 1)
                    {
                        e2 = 1;
                        turn = 2;
                    }  
                }
                if (x > 800 && y > 100 && y <= 200 && f2 == 0) // f2
                {
                    if (turn == 1)
                    {
                        f2 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 700 && x > 600 && y > 200 && y <= 300 && g2 == 0) // g2
                {
                    if (turn == 1)
                    {
                        g2 = 1;
                        turn = 2;
                    }      
                }
                if (x > 700 && x <= 800 && y <= 300 && y > 200 && h2 == 0) //h2
                {
                    if (turn == 1)
                    {
                        h2 = 1;
                        turn = 2;
                    }       
                }
                if (x > 800 && y > 200 && y <= 300 && i2 == 0) // i2
                {
                    if (turn == 1)
                    {
                        i2 = 1;
                        turn = 2;
                    }     
                }
            }
            // in big box u
            if (u == 0)
            {
                if (x <= 100 && y > 300 && y <= 400 && a3 == 0) // clicked on box a3
                {
                    if (turn == 1)
                    {
                        a3 = 1;
                        turn = 2;
                    }
                }
                if (x > 100 && x <= 200 && y <= 400 && y > 300 && b3 == 0) //b3
                {
                    if (turn == 1)
                    {
                        b3 = 1;
                        turn = 2;
                    } 
                }
                if (x > 200 && x <= 300 && y <= 400 && y > 300 && c3 == 0) // c3
                {
                    if (turn == 1)
                    {
                        c3 = 1;
                        turn = 2;
                    }  
                }
                if (x <= 100 && y > 400 && y <= 500 && d3 == 0) // d3
                {
                    if (turn == 1)
                    {
                        d3 = 1;
                        turn = 2;
                    } 
                }
                if (x > 100 && x <= 200 && y > 400 && y <= 500 && e3 == 0) // e3
                {
                    if (turn == 1)
                    {
                        e3 = 1;
                        turn = 2;
                    }
                }
                if (x > 200 && x <= 300 && y > 400 && y <= 500 && f3 == 0) // f3
                {
                    if (turn == 1)
                    {
                        f3 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 100 && y > 200 && y <= 600 && y > 500 && g3 == 0) // g3
                {
                    if (turn == 1)
                    {
                        g3 = 1;
                        turn = 2;
                    }      
                }
                if (x > 100 && x <= 200 && y <= 600 && y > 500 && h3 == 0) //h3
                {
                    if (turn == 1)
                    {
                        h3 = 1;
                        turn = 2;
                    }       
                }
                if (x <= 300 && x > 200 && y > 500 && y <= 600 && i3 == 0) // i3
                {
                    if (turn == 1)
                    {
                        i3 = 1;
                        turn = 2;
                    }       
                }
            }
            //in big box v
            if (v == 0)
            {
                if (x <= 400 && x > 300 && y <= 400 && y > 300 && a4 == 0) // clicked on box a4
                {
                    if (turn == 1)
                    {
                        a4 = 1;
                        turn = 2;
                    }
                }
                if (x > 400 && x <= 500 && y <= 400 && y > 300 && b4 == 0) //b4
                {
                    if (turn == 1)
                    {
                        b4 = 1;
                        turn = 2;
                    } 
                }
                if (x > 500 && x <= 600 && y <= 400 && y > 300 && c4 == 0) // c4
                {
                    if (turn == 1)
                    {
                        c4 = 1;
                        turn = 2;
                    } 
                }
                if (x <= 400 && x > 300 && y > 400 && y <= 500 && d4 == 0) // d4
                {
                    if (turn == 1)
                    {
                        d4 = 1;
                        turn = 2;
                    } 
                }
                if (x > 400 && x <= 500 && y > 400 && y <= 500 && e4 == 0) // e4
                {
                    if (turn == 1)
                    {
                        e4 = 1;
                        turn = 2;
                    } 
                }
                if (x > 500 && x <= 600 && y > 400 && y <= 500 && f4 == 0) // f4
                {
                    if (turn == 1)
                    {
                        f4 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 400 && x > 300 && y > 500 && y <= 600 && g4 == 0) // g4
                {
                    if (turn == 1)
                    {
                        g4 = 1;
                        turn = 2;
                    }     
                }
                if (x > 400 && x <= 500 && y <= 600 && y > 500 && h4 == 0) //h4
                {
                    if (turn == 1)
                    {
                        h4 = 1;
                        turn = 2;
                    }     
                }
                if (x <= 600 && x > 500 && y > 500 && y <= 600 && i4 == 0) // i4
                {
                    if (turn == 1)
                    {
                        i4 = 1;
                        turn = 2;
                    }      
                }
            }
            //in big box w
            if (w == 0)
            {
                if (x <= 700 && x > 600 && y <= 400 && y > 300 && a5 == 0) // clicked on box a5
                {
                    if (turn == 1)
                    {
                        a5 = 1;
                        turn = 2;
                    }
                }
                if (x > 700 && x <= 800 && y <= 400 && y > 300 && b5 == 0) //b5
                {
                    if (turn == 1)
                    {
                        b5 = 1;
                        turn = 2;
                    } 
                }
                if (x > 800 && y <= 400 && y > 300 && c5 == 0) // c5
                {
                    if (turn == 1)
                    {
                        c5 = 1;
                        turn = 2;
                    }  
                }
                if (x <= 700 && x > 600 && y > 400 && y <= 500 && d5 == 0) // d5
                {
                    if (turn == 1)
                    {
                        d5 = 1;
                        turn = 2;
                    }
                }
                if (x > 700 && x <= 800 && y > 400 && y <= 500 && e5 == 0) // e5
                {
                    if (turn == 1)
                    {
                        e5 = 1;
                        turn = 2;
                    }  
                }
                if (x > 800 && y > 400 && y <= 500 && f5 == 0) // f5
                {
                    if (turn == 1)
                    {
                        f5 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 700 && x > 600 && y > 500 && y <= 600 && g5 == 0) // g5
                {
                    if (turn == 1)
                    {
                        g5 = 1;
                        turn = 2;
                    }      
                }
                if (x > 700 && x <= 800 && y <= 600 && y > 500 && h5 == 0) //h5
                {
                    if (turn == 1)
                    {
                        h5 = 1;
                        turn = 2;
                    }      
                }
                if (x > 800 && y > 500 && y <= 600 && i5 == 0) // i5
                {
                    if (turn == 1)
                    {
                        i5 = 1;
                        turn = 2;
                    }      
                }
            }
            // in big box x1
            if (x1 == 0)
            {
                if (x <= 100 && y > 600 && y <= 700 && a6 == 0) // clicked on box a6
                {
                    if (turn == 1)
                    {
                        a6 = 1;
                        turn = 2;
                    }
                }
                if (x > 100 && x <= 200 && y <= 700 && y > 600 && b6 == 0) //b6
                {
                    if (turn == 1)
                    {
                        b6 = 1;
                        turn = 2;
                    } 
                }
                if (x > 200 && x <= 300 && y <= 700 && y > 600 && c6 == 0) // c6
                {
                    if (turn == 1)
                    {
                        c6 = 1;
                        turn = 2;
                    } 
                }
                if (x <= 100 && y > 700 && y <= 800 && d6 == 0) // d6
                {
                    if (turn == 1)
                    {
                        d6 = 1;
                        turn = 2;
                    }
                }
                if (x > 100 && x <= 200 && y > 700 && y <= 800 && e6 == 0) // e6
                {
                    if (turn == 1)
                    {
                        e6 = 1;
                        turn = 2;
                    }  
                }
                if (x > 200 && x <= 300 && y > 700 && y <= 800 && f6 == 0) // f6
                {
                    if (turn == 1)
                    {
                        f6 = 1;
                        turn = 2;
                    }     
                }
                if (x <= 100 && y > 800 && g6 == 0) // g6
                {
                    if (turn == 1)
                    {
                        g6 = 1;
                        turn = 2;
                    }       
                }
                if (x > 100 && x <= 200 && y > 800 && h6 == 0) //h6
                {
                    if (turn == 1)
                    {
                        h6 = 1;
                        turn = 2;
                    }       
                }
                if (x <= 300 && x > 200 && y > 800 && i6 == 0) // i6
                {
                    if (turn == 1)
                    {
                        i6 = 1;
                        turn = 2;
                    }       
                }
            }

            //in big box y1
            if (y1 == 0)
            {
                if (x <= 400 && x > 300 && y <= 700 && y > 600 && a7 == 0) // clicked on box a7
                {
                    if (turn == 1)
                    {
                        a7 = 1;
                        turn = 2;
                    }
                }
                if (x > 400 && x <= 500 && y <= 700 && y > 600 && b7 == 0) //b7
                {
                    if (turn == 1)
                    {
                        b7 = 1;
                        turn = 2;
                    }  
                }
                if (x > 500 && x <= 600 && y <= 700 && y > 600 && c7 == 0) // c7
                {
                    if (turn == 1)
                    {
                        c7 = 1;
                        turn = 2;
                    }  
                }
                if (x <= 400 && x > 300 && y > 700 && y <= 800 && d7 == 0) // d7
                {
                    if (turn == 1)
                    {
                        d7 = 1;
                        turn = 2;
                    } 
                }
                if (x > 400 && x <= 500 && y > 700 && y <= 800 && e7 == 0) // e7
                {
                    if (turn == 1)
                    {
                        e7 = 1;
                        turn = 2;
                    }   
                }
                if (x > 500 && x <= 600 && y > 700 && y <= 800 && f7 == 0) // f7
                {
                    if (turn == 1)
                    {
                        f7 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 400 && x > 300 && y > 800 && g7 == 0) // g7
                {
                    if (turn == 1)
                    {
                        g7 = 1;
                        turn = 2;
                    }       
                }
                if (x > 400 && x <= 500 && y > 800 && h7 == 0) //h7
                {
                    if (turn == 1)
                    {
                        h7 = 1;
                        turn = 2;
                    }       
                }
                if (x <= 600 && x > 500 && y > 800 && i7 == 0) // i7
                {
                    if (turn == 1)
                    {
                        i7 = 1;
                        turn = 2;
                    }      
                }
            }

            //in big box z
            if (z == 0)
            {
                if (x <= 700 && x > 600 && y <= 700 && y > 600 && a8 == 0) // clicked on box a8
                {
                    if (turn == 1)
                    {
                        a8 = 1;
                        turn = 2;
                    }
                }
                if (x > 700 && x <= 800 && y <= 700 && y > 600 && b8 == 0) //b8
                {
                    if (turn == 1)
                    {
                        b8 = 1;
                        turn = 2;
                    } 
                }
                if (x > 800 && y <= 700 && y > 600 && c8 == 0) // c8
                {
                    if (turn == 1)
                    {
                        c8 = 1;
                        turn = 2;
                    } 
                }
                if (x <= 700 && x > 600 && y > 700 && y <= 800 && d8 == 0) // d8
                {
                    if (turn == 1)
                    {
                        d8 = 1;
                        turn = 2;
                    }  
                }
                if (x > 700 && x <= 800 && y > 700 && y <= 800 && e8 == 0) // e8
                {
                    if (turn == 1)
                    {
                        e8 = 1;
                        turn = 2;
                    }   
                }
                if (x > 800 && y > 700 && y <= 800 && f8 == 0) // f8
                {
                    if (turn == 1)
                    {
                        f8 = 1;
                        turn = 2;
                    }    
                }
                if (x <= 700 && x > 600 && y > 800 && g8 == 0) // g8
                {
                    if (turn == 1)
                    {
                        g8 = 1;
                        turn = 2;
                    }       
                }
                if (x > 700 && x <= 800 && y > 800 && h8 == 0) //h8
                {
                    if (turn == 1)
                    {
                        h8 = 1;
                        turn = 2;
                    }       
                }
                if (x > 800 && y > 800 && i8 == 0) // i8
                {
                    if (turn == 1)
                    {
                        i8 = 1;
                        turn = 2;
                    }      
                }
            }
            computerMoveHard();
        }

        repaint();
    }

    public void computerMove() // 3x3 board
    {
        // offensive moves
        // horizontal win
        if (turn == 2) // wasn't working without this
        {
            if (a == 2 && b == 2 && c == 0)
                c = 2;
            else if (a == 2 && b == 0 && c == 2)
                b = 2;
            else if (a == 0 && b == 2 && c == 2)
                a = 2;
            else if (d == 2 && e1 == 2 && f == 0)
                f = 2;
            else if (d == 2 && e1 == 0 && f == 2)
                e1 = 2;
            else if (d == 0 && e1 == 2 && f == 2)
                d = 2;
            else if (g1 == 2 && h == 2 && i == 0)
                i = 2;
            else if (g1 == 2 && h == 0 && i == 2)
                h = 2;
            else if (g1 == 0 && h == 2 && i == 2)
                g1 = 2;
            // vertical win
            else if (a == 2 && d == 2 && g1 == 0)
                g1 = 2;
            else if (a == 2 && d == 0 && g1 == 2)
                d = 2;
            else if (a == 0 && d == 2 && g1 == 2)
                a = 2;
            else if (b == 2 && e1 == 2 && h == 0)
                h = 2;
            else if (b == 2 && e1 == 0 && h == 2)
                e1 = 2;
            else if (b == 0 && e1 == 2 && h == 2)
                h = 2;
            else if (c == 2 && f == 2 && i == 0)
                i = 2;
            else if (c == 2 && f == 0 && i == 2)
                f = 2;
            else if (c == 0 && f == 2 && i == 2)
                c = 2;
            //diagonal win
            else if (a == 2 && e1 == 2 && i == 0)
                i = 2;
            else if (a == 2 && e1 == 0 && i == 2)
                e1 = 2;
            else if (a == 0 && e1 == 2 && i == 2)
                a = 2;
            else if (c == 2 && e1 == 2 && g1 == 0)
                g1 = 2;
            else if (c == 2 && e1 == 0 && g1 == 2)
                e1 = 2;
            else if (c == 0 && e1 == 2 && g1 == 2)
                c = 2;
            // defensive moves
            // horizontal blocking
            else if (a == 1 && b == 1 && c == 0)
                c = 2;
            else if (a == 1 && b == 0 && c == 1)
                b = 2;
            else if (a == 0 && b == 1 && c == 1)
                a = 2;
            else if (d == 1 && e1 == 1 && f == 0)
                f = 2;
            else if (d == 1 && e1 == 0 && f == 1)
                e1 = 2;
            else if (d == 0 && e1 == 1 && f == 1)
                d = 2;
            else if (g1 == 1 && h == 1 && i == 0)
                i = 2;
            else if (g1 == 1 && h == 0 && i == 1)
                h = 2;
            else if (g1 == 0 && h == 1 && i == 1)
                g1 = 2;
            // vertical blocking
            else if (a == 1 && d == 1 && g1 == 0)
                g1 = 2;
            else if (a == 1 && d == 0 && g1 == 1)
                d = 2;
            else if (a == 0 && d == 1 && g1 == 1)
                a = 2;
            else if (b == 1 && e1 == 1 && h == 0)
                h = 2;
            else if (b == 1 && e1 == 0 && h == 1)
                e1 = 2;
            else if (b == 0 && e1 == 1 && h == 1)
                b = 2;
            else if (c == 1 && f == 1 && i == 0)
                i = 2;
            else if (c == 1 && f == 0 && i == 1)
                f = 2;
            else if (c == 0 && f == 1 && i == 1)
                c = 2;
            //diagonal blocking
            else if (a == 1 && e1 == 1 && i == 0)
                i = 2;
            else if (a == 1 && e1 == 0 && i == 1)
                e1 = 2;
            else if (a == 0 && e1 == 1 && i == 1)
                a = 2;
            else if (c == 1 && e1 == 1 && g1 == 0)
                g1 = 2;
            else if (c == 1 && e1 == 0 && g1 == 1)
                e1 = 2;
            else if (c == 0 && e1 == 1 && g1 == 1)
                c = 2;
            // first move
            else if (e1 == 0)
                e1 = 2;
            // two sides
            else if (b == 1 && d == 1 && e1 == 2 && a == 0)
                a = 2;
            else if (b == 1 && f == 1 && e1 == 2 && c == 0)
                c = 2;
            else if (f == 1 && h == 1 && e1 == 2 && i == 0)
                i = 2;
            else if (d == 1 && h == 1 && e1 == 2 && g1 == 0)
                g1 = 2;
            else if (a == 0 && c == 0 && g1 == 0 && i == 0) // picks a random corner for move 1
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a = 2;
                else if (corner == 2)
                    c = 2;
                else if (corner == 3)
                    g1 = 2;
                else if (corner == 4)
                    i = 2;
            }
            // other scenarios
            //diagonal line (no two in a row)
            else if (a == 2 && e1 == 1 && i == 1 && g1 == 0)
                g1 = 2;
            else if (c == 2 && e1 == 1 && g1 == 1 && a == 0)
                a = 2;
            else if (i == 2 && e1 == 1 && a == 1 && c == 0)
                c = 2;
            else if (g1 == 2 && e1 == 1 && c == 1 && i == 0)
                i = 2;
            else if (a == 1 && i == 1 && d == 0)
                d = 2;
            else if (c == 1 && g1 == 1 && f == 0)
                f = 2;
            // T scenario
            else if (a == 1 && c == 1 && h == 1 && e1 == 2 && b == 2 && d == 0)
                d = 2;
            else if (c == 1 && i == 1 && d == 1 && e1 == 2 && f == 2 &&  b == 0)
                b = 2;
            else if (b == 1 && g1 == 1 && i == 1 && e1 == 2 && h == 2 && f == 0)
                f = 2;
            else if (a == 1 && g1 == 1 && f == 1 && e1 == 2 && d == 2 && h == 0)
                h = 2;
            // reverse T / H scenario
            else if (a == 2 && c == 2 && h == 2 && e1 == 1 && b == 1 && d == 0)
                d = 2;
            else if (c == 2 && i == 2 && d == 2 && e1 == 1 && f == 1 &&  b == 0)
                b = 2;
            else if (b == 2 && g1 == 2 && i == 2 && e1 == 1 && h == 1 && f == 0)
                f = 2;
            else if (a == 2 && g1 == 2 && f == 2 && e1 == 1 && d == 1 && h == 0)
                h = 2;
            // one corner and a side
            else if (a == 1 && e1 == 2 && f == 1 && c == 0)
                c = 2;
            else if (a == 1 && e1 == 2 && h == 1 && g1 == 0)
                g1 = 2;
            else if (c == 1 && e1 == 2 && h == 1 && i == 0)
                i = 2;
            else if (c == 1 && e1 == 2 && d == 1 && a == 0)
                a = 2;
            else if (i == 1 && e1 == 2 && d == 1 && g1 == 0)
                g1 = 2;
            else if (i == 1 && e1 == 2 && b == 1 && c == 0)
                c = 2;
            else if (g1 == 1 && e1 == 2 && b == 1 && a == 0)
                a = 2;
            else if (g1 == 1 && e1 == 2 && f == 1 && i == 0)
                i = 2;
        }

        turn = 1;
    }

    public void computerMoveMed() // 4x4 board
    {
        // offensive moves
        if (turn == 2) // wasn't working without this
        {
            //horizontal win
            if (a == 2 && b == 2 && c == 2 && d == 0)
                d = 2;
            else if (a == 2 && b == 2 && c == 0 && d == 2)
                c = 2;
            else if (a == 2 && b == 0 && c == 2 && d == 2)
                b = 2;
            else if (a == 0 && b == 2 && c == 2 && d == 2)
                a = 2;
            else if (e1 == 2 && f == 2 && g1 == 2 && h == 0)
                h = 2;
            else if (e1 == 2 && f == 2 && g1 == 0 && h == 2)
                g1 = 2;
            else if (e1 == 2 && f == 0 && g1 == 2 && h == 2)
                f = 2;
            else if (e1 == 0 && f == 2 && g1 == 2 && h == 2)
                e1= 2;
            else if (i == 2 && j == 2 && k == 2 && l == 0) 
                l = 2;
            else if (i == 2 && j == 2 && k == 0 && l == 2) 
                k = 2;
            else if (i == 2 && j == 0 && k == 2 && l == 2) 
                j = 2;
            else if (i == 0 && j == 2 && k == 2 && l == 2) 
                i = 2;
            else if (m == 2 && n == 2 && o == 2 && p == 0) 
                p = 2;
            else if (m == 2 && n == 2 && o == 0 && p == 2) 
                o = 2;
            else if (m == 2 && n == 0 && o == 2 && p == 2) 
                n = 2;
            else if (m == 0 && n == 2 && o == 2 && p == 2) 
                m = 2;
            // vertical win
            else if (a == 2 && e1 == 2 && i == 2 && m == 0)
                m = 2;
            else if (a == 2 && e1 == 2 && i == 0 && m == 2)
                i = 2;
            else if (a == 2 && e1 == 0 && i == 2 && m == 2)
                e1 = 2;
            else if (a == 0 && e1 == 2 && i == 2 && m == 2)
                a = 2;
            else if (b == 2 && f == 2 && j == 2 && n == 0)
                n = 2;
            else if (b == 2 && f == 2 && j == 0 && n == 2)
                j = 2;
            else if (b == 2 && f == 0 && j == 2 && n == 2)
                f = 2;
            else if (b == 0 && f == 2 && j == 2 && n == 2)
                b = 2;
            else if (c == 2 && g1 == 2 && k == 2 && o == 0)
                o = 2;
            else if (c == 2 && g1 == 2 && k == 0 && o == 2)
                k = 2;
            else if (c == 2 && g1 == 0 && k == 2 && o == 2)
                g1 = 2;
            else if (c == 0 && g1 == 2 && k == 2 && o == 2)
                c = 2;
            else if (d == 2 && h == 2 && l == 2 && p == 0)
                p = 2;
            else if (d == 2 && h == 2 && l == 0 && p == 2)
                l = 2;
            else if (d == 2 && h == 0 && l == 2 && p == 2)
                h = 2;
            else if (d == 0 && h == 2 && l == 2 && p == 2)
                d = 2;
            //diagonal win
            else if (a == 2 && f == 2 && k == 2 && p == 0)
                p = 2;
            else if (a == 2 && f == 2 && k == 0 && p == 2)
                k = 2;
            else if (a == 2 && f == 0 && k == 2 && p == 2)
                f = 2;
            else if (a == 0 && f == 2 && k == 2 && p == 2)
                a = 2;
            else if (d == 2 && g1 == 2 && j == 2 && m == 0)
                m = 2;
            else if (d == 2 && g1 == 2 && j == 0 && m == 2)
                j = 2;
            else if (d == 2 && g1 == 0 && j == 2 && m == 2)
                g1 = 2;
            else if (d == 0 && g1 == 2 && j == 2 && m == 2)
                d = 2;
            // defensive moves
            // horizontal blocking
            else if (a == 1 && b == 1 && c == 1 && d == 0)
                d = 2;
            else if (a == 1 && b == 1 && c == 0 && d == 1)
                c = 2;
            else if (a == 1 && b == 0 && c == 1 && d == 1)
                b = 2;
            else if (a == 0 && b == 1 && c == 1 && d == 1)
                a = 2;
            else if (e1 == 1 && f == 1 && g1 == 1 && h == 0)
                h = 2;
            else if (e1 == 1 && f == 1 && g1 == 0 && h == 1)
                g1 = 2;
            else if (e1 == 1 && f == 0 && g1 == 1 && h == 1)
                f = 2;
            else if (e1 == 0 && f == 1 && g1 == 1 && h == 1)
                e1 = 2;
            else if (i == 1 && j == 1 && k == 1 && l == 0)
                l = 2;
            else if (i == 1 && j == 1 && k == 0 && l == 1)
                k = 2;
            else if (i == 1 && j == 0 && k == 1 && l == 1)
                j = 2;
            else if (i == 0 && j == 1 && k == 1 && l == 1)
                i = 2;
            else if (m == 1 && n == 1 && o == 1 && p == 0)
                p = 2;
            else if (m == 1 && n == 1 && o == 0 && p == 1)
                o = 2;
            else if (m == 1 && n == 0 && o == 1 && p == 1)
                n = 2;
            else if (m == 0 && n == 1 && o == 1 && p == 1)
                m = 2;
            // vertical blocking
            else if (a == 1 && e1 == 1 && i == 1 && m == 0)
                m = 2;
            else if (a == 1 && e1 == 1 && i == 0 && m == 1)
                i = 2;
            else if (a == 1 && e1 == 0 && i == 1 && m == 1)
                e1 = 2;
            else if (a == 0 && e1 == 1 && i == 1 && m == 1)
                a = 2;
            else if (b == 1 && f == 1 && j == 1 && n == 0)
                n = 2;
            else if (b == 1 && f == 1 && j == 0 && n == 1)
                j = 2;
            else if (b == 1 && f == 0 && j == 1 && n == 1)
                f = 2;
            else if (b == 0 && f == 1 && j == 1 && n == 1)
                b = 2;
            else if (c == 1 && g1 == 1 && k == 1 && o == 0)
                o = 2;
            else if (c == 1 && g1 == 1 && k == 0 && o == 1)
                k = 2;
            else if (c == 1 && g1 == 0 && k == 1 && o == 1)
                g1 = 2;
            else if (c == 0 && g1 == 1 && k == 1 && o == 1)
                c = 2;
            else if (d == 1 && h == 1 && l == 1 && p == 0)
                p = 2;
            else if (d == 1 && h == 1 && l == 0 && p == 1)
                l = 2;
            else if (d == 1 && h == 0 && l == 1 && p == 1)
                h = 2;
            else if (d == 0 && h == 1 && l == 1 && p == 1)
                d = 2;
            //diagonal blocking
            else if (a == 1 && f == 1 && k == 1 && p == 0)
                p = 2;
            else if (a == 1 && f == 1 && k == 0 && p == 1)
                k = 2;
            else if (a == 1 && f == 0 && k == 1 && p == 1)
                f = 2;
            else if (a == 0 && f == 1 && k == 1 && p == 1)
                a = 2;
            else if (d == 1 && g1 == 1 && j == 1 && m == 0)
                m = 2;
            else if (d == 1 && g1 == 1 && j == 0 && m == 1)
                j = 2;
            else if (d == 1 && g1 == 0 && j == 1 && m == 1)
                g1 = 2;
            else if (d == 0 && g1 == 1 && j == 1 && m == 1)
                d = 2;
            // first move
            else if (a == 0 && d == 0 && m == 0 && p == 0) // picks a random corner for move 1
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a = 2;
                else if (corner == 2)
                    d = 2;
                else if (corner == 3)
                    m = 2;
                else if (corner == 4)
                    p = 2;
            }
            else if (a == 0)
                a = 2;
            else if (d == 0)
                d = 2;
            else if (m == 0)
                m = 2;
            else if (p == 0)
                p = 2;
            else if (a == 2 && f == 0)
                f = 2;
            else if (d == 2 && g1 == 0)
                g1 = 2;
            else if (m == 2 && j == 0)
                j = 2;
            else if (p == 2 && k == 0)
                k = 2;
            else if (a == 2 && e1 == 0)
                e1 = 2;
            else if (d == 2 && h == 0)
                h = 2;
            else if (m == 2 && i == 0)
                i = 2;
            else if (p == 2 && l == 0)
                l = 2;

            // two in a row
            //horizontal
            else if (a == 2 && b == 2 && c == 0)
                c = 2;
            else if (b == 2 && c == 2 && d == 0)
                d = 2;
            else if (a == 0 && b == 2 && c == 2)
                a = 2;
            else if (c == 2 && d == 2 && b == 0)
                b = 2;
            else if (e1 == 2 && f == 2 && g1 == 0)
                g1 = 2;
            else if (f == 2 && g1 == 2 && h == 0)
                h = 2;
            else if (e1 == 0 && f == 2 && g1 == 2)
                a = 2;
            else if (h == 2 && g1 == 2 && f == 0)
                f = 2;
            else if (i == 2 && j == 2 && k == 0)
                k = 2;
            else if (j == 2 && k == 2 && l == 0)
                l = 2;
            else if (i == 0 && j == 2 && k == 2)
                i = 2;
            else if (k == 2 && l == 2 && j == 0)
                j = 2;
            else if (m == 2 && n == 2 && o == 0)
                o = 2;
            else if (n == 2 && o == 2 && p == 0)
                p = 2;
            else if (m == 0 && n == 2 && o == 2)
                m = 2;
            else if (o == 2 && p == 2 && n == 0)
                n = 2;
            // vertical
            else if (a == 2 && e1 == 2 && i == 0)
                i = 2;
            else if (e1 == 2 && i == 2 && m == 0)
                m = 2;
            else if (a == 0 && e1 == 2 && i == 2)
                a = 2;
            else if (i == 2 && m == 2 && e1 == 0)
                e1 = 2;
            else if (b == 2 && f == 2 && j == 0)
                j = 2;
            else if (f == 2 && j == 2 && n == 0)
                n = 2;
            else if (b == 0 && f == 2 && j == 2)
                b = 2;
            else if (n == 2 && j == 2 && f == 0)
                f = 2;
            else if (c == 2 && g1 == 2 && k == 0)
                k = 2;
            else if (g1 == 2 && k == 2 && o == 0)
                o = 2;
            else if (c == 0 && g1 == 2 && k == 2)
                c = 2;
            else if (k == 2 && o == 2 && g1 == 0)
                g1 = 2;
            else if (d == 2 && i == 2 && l == 0)
                l = 2;
            else if (i == 2 && l == 2 && p == 0)
                p = 2;
            else if (d == 0 && i == 2 && l == 2)
                d = 2;
            else if (l == 2 && p == 2 && i == 0)
                i= 2;
            //diagonal
            else if (a == 2 && f == 2 && k == 0)
                k = 2;
            else if (f == 2 && k == 2 && p == 0)
                d = 2;
            else if (a == 0 && f == 2 && k == 2)
                a = 2;
            else if (k == 2 && p == 2 && f == 0)
                f = 2;
            else if (d == 2 && g1 == 2 && j == 0)
                j = 2;
            else if (g1 == 2 && j == 2 && m == 0)
                m = 2;
            else if (d == 0 && g1 == 2 && j == 2)
                d = 2;
            else if (m == 2 && j == 2 && g1 == 0)
                g1 = 2;
            // only spot left
            else if (a == 0)
                a = 2;
            else if (b == 0)
                b = 2;
            else if (c == 0)
                c = 2;
            else if (d == 0)
                d = 2;
            else if (e1 == 0)
                e1 = 2;
            else if (f == 0)
                f = 2;
            else if (g1 == 0)
                g1 = 2;
            else if (h == 0)
                h = 2;
            else if (i == 0)
                i = 2;
            else if (j == 0)
                j = 2;
            else if (k == 0)
                k = 2;
            else if (l == 0)
                l = 2;
            else if (m == 0)
                m = 2;
            else if (n == 0)
                n = 2;
            else if (o == 0)
                o = 2;
            else if (p == 0)
                p = 2;
        }

        turn = 1;
    }

    public void computerMoveHard() // big board
    {
        if (turn == 2) // wasn't working without this
        {
            //win moves

            // box r
            // horizontal win
            if (a == 2 && b == 2 && c == 0 && r == 0)
                c = 2;
            else if (a == 2 && b == 0 && c == 2 && r == 0)
                b = 2;
            else if (a == 0 && b == 2 && c == 2 && r == 0)
                a = 2;
            else if (d == 2 && e1 == 2 && f == 0 && r == 0)
                f = 2;
            else if (d == 2 && e1 == 0 && f == 2 && r == 0)
                e1 = 2;
            else if (d == 0 && e1 == 2 && f == 2 && r == 0)
                d = 2;
            else if (g1 == 2 && h == 2 && i == 0 && r == 0)
                i = 2;
            else if (g1 == 2 && h == 0 && i == 2 && r == 0)
                h = 2;
            else if (g1 == 0 && h == 2 && i == 2 && r == 0)
                g1 = 2;
            // vertical win
            else if (a == 2 && d == 2 && g1 == 0 && r == 0)
                g1 = 2;
            else if (a == 2 && d == 0 && g1 == 2 && r == 0)
                d = 2;
            else if (a == 0 && d == 2 && g1 == 2 && r == 0)
                a = 2;
            else if (b == 2 && e1 == 2 && h == 0 && r == 0)
                h = 2;
            else if (b == 2 && e1 == 0 && h == 2 && r == 0)
                e1 = 2;
            else if (b == 0 && e1 == 2 && h == 2 && r == 0)
                b = 2;
            else if (c == 2 && f == 2 && i == 0 && r == 0)
                i = 2;
            else if (c == 2 && f == 0 && i == 2 && r == 0)
                f = 2;
            else if (c == 0 && f == 2 && i == 2 && r == 0)
                c = 2;
            //diagonal win
            else if (a == 2 && e1 == 2 && i == 0 && r == 0)
                i = 2;
            else if (a == 2 && e1 == 0 && i == 2 && r == 0)
                e1 = 2;
            else if (a == 0 && e1 == 2 && i == 2 && r == 0)
                a = 2;
            else if (c == 2 && e1 == 2 && g1 == 0 && r == 0)
                g1 = 2;
            else if (c == 2 && e1 == 0 && g1 == 2 && r == 0)
                e1 = 2;
            else if (c == 0 && e1 == 2 && g1 == 2 && r == 0)
                c = 2;

            // box s
            else if (a1 == 2 && b1 == 2 && c1 == 0 && s == 0)
                c1 = 2;
            else if (a1 == 2 && b1 == 0 && c1 == 2 && s == 0)
                b1 = 2;
            else if (a1 == 0 && b1 == 2 && c1 == 2 && s == 0)
                a1 = 2;
            else if (d1 == 2 && e11 == 2 && f1 == 0 && s == 0)
                f1 = 2;
            else if (d == 2 && e1 == 0 && f == 2 && s == 0)
                e1 = 2;
            else if (d1 == 0 && e11 == 2 && f1 == 2 && s == 0)
                d1 = 2;
            else if (g11 == 2 && h1 == 2 && i1 == 0 && s == 0)
                i1 = 2;
            else if (g11 == 2 && h1 == 0 && i1 == 2 && s == 0)
                h1 = 2;
            else if (g11 == 0 && h1 == 2 && i1 == 2 && s == 0)
                g11 = 2;
            // vertical win
            else if (a1 == 2 && d1 == 2 && g11 == 0 && s == 0)
                g11 = 2;
            else if (a1 == 2 && d1 == 0 && g11 == 2 && s == 0)
                d1 = 2;
            else if (a1 == 0 && d1 == 2 && g11 == 2 && s == 0)
                a1 = 2;
            else if (b1 == 2 && e11 == 2 && h1 == 0 && s == 0)
                h1 = 2;
            else if (b1 == 2 && e11 == 0 && h1 == 2 && s == 0)
                e11 = 2;
            else if (b1 == 0 && e11 == 2 && h1 == 2 && s == 0)
                b1 = 2;
            else if (c1 == 2 && f1 == 2 && i1 == 0 && s == 0)
                i1 = 2;
            else if (c1 == 2 && f1 == 0 && i1 == 2 && s == 0)
                f1 = 2;
            else if (c1 == 0 && f1 == 2 && i1 == 2 && s == 0)
                c1 = 2;
            //diagonal win
            else if (a1 == 2 && e11 == 2 && i1 == 0 && s == 0)
                i1 = 2;
            else if (a1 == 2 && e11 == 0 && i1 == 2 && s == 0)
                e1 = 2;
            else if (a1 == 0 && e11 == 2 && i1 == 2 && s == 0)
                a1 = 2;
            else if (c1 == 2 && e11 == 2 && g11 == 0 && s == 0)
                g1 = 2;
            else if (c1 == 2 && e11 == 0 && g11 == 2 && s == 0)
                e1 = 2;
            else if (c1 == 0 && e11 == 2 && g11 == 2 && s == 0)
                c1 = 2;

            // box t
            else if (a2 == 2 && b2 == 2 && c2 == 0 && t == 0)
                c2 = 2;
            else if (a2 == 2 && b2 == 0 && c2 == 2 && t == 0)
                b2 = 2;
            else if (a2 == 0 && b2 == 2 && c2 == 2 && t == 0)
                a2 = 2;
            else if (d2 == 2 && e2 == 2 && f2 == 0 && t == 0)
                f2 = 2;
            else if (d2 == 2 && e2 == 0 && f2 == 2 && t == 0)
                e2 = 2;
            else if (d2 == 0 && e2 == 2 && f2 == 2 && t == 0)
                d2 = 2;
            else if (g2 == 2 && h2 == 2 && i2 == 0 && t == 0)
                i2 = 2;
            else if (g2 == 2 && h2 == 0 && i2 == 2 && t == 0)
                h2 = 2;
            else if (g2 == 0 && h2 == 2 && i2 == 2 && t == 0)
                g2 = 2;
            // vertical win
            else if (a2 == 2 && d2 == 2 && g2 == 0 && t == 0)
                g2 = 2;
            else if (a2 == 2 && d2 == 0 && g2 == 2 && t == 0)
                d2 = 2;
            else if (a2 == 0 && d2 == 2 && g2 == 2 && t == 0)
                a2 = 2;
            else if (b2 == 2 && e2 == 2 && h2 == 0 && t == 0)
                h2 = 2;
            else if (b2 == 2 && e2 == 0 && h2 == 2 && t == 0)
                e2 = 2;
            else if (b2 == 0 && e2 == 2 && h2 == 2 && t == 0)
                b2 = 2;
            else if (c2 == 2 && f2 == 2 && i2 == 0 && t == 0)
                i2 = 2;
            else if (c2 == 2 && f2 == 0 && i2 == 2 && t == 0)
                f2 = 2;
            else if (c2 == 0 && f2 == 2 && i2 == 2 && t == 0)
                c2 = 2;
            //diagonal win
            else if (a2 == 2 && e2 == 2 && i2 == 0 && t == 0)
                i2 = 2;
            else if (a2 == 2 && e2 == 0 && i2 == 2 && t == 0)
                e2 = 2;
            else if (a2 == 0 && e2 == 2 && i2 == 2 && t == 0)
                a2 = 2;
            else if (c2 == 2 && e2 == 2 && g2 == 0 && t == 0)
                g2 = 2;
            else if (c2 == 2 && e2 == 0 && g2 == 2 && t == 0)
                e2 = 2;
            else if (c2 == 0 && e2 == 2 && g2 == 2 && t == 0)
                c2 = 2;

            // box u
            else if (a3 == 2 && b3 == 2 && c3 == 0 && u == 0)
                c3 = 2;
            else if (a3 == 2 && b3 == 0 && c3 == 2 && u == 0)
                b3 = 2;
            else if (a3 == 0 && b3 == 2 && c3 == 2 && u == 0)
                a3 = 2;
            else if (d3 == 2 && e3 == 2 && f3 == 0 && u == 0)
                f3 = 2;
            else if (d3 == 2 && e3 == 0 && f3 == 2 && u == 0)
                e3 = 2;
            else if (d3 == 0 && e3 == 2 && f3 == 2 && u == 0)
                d3 = 2;
            else if (g3 == 2 && h3 == 2 && i3 == 0 && u == 0)
                i3 = 2;
            else if (g3 == 2 && h3 == 0 && i3 == 2 && u == 0)
                h3 = 2;
            else if (g3 == 0 && h3 == 2 && i3 == 2 && u == 0)
                g3 = 2;
            // vertical win
            else if (a3 == 2 && d3 == 2 && g3 == 0 && u == 0)
                g3 = 2;
            else if (a3 == 2 && d3 == 0 && g3 == 2 && u == 0)
                d3 = 2;
            else if (a3 == 0 && d3 == 2 && g3 == 2 && u == 0)
                a3 = 2;
            else if (b3 == 2 && e3 == 2 && h3 == 0 && u == 0)
                h3 = 2;
            else if (b3 == 2 && e3 == 0 && h3 == 2 && u == 0)
                e3 = 2;
            else if (b3 == 0 && e3 == 2 && h3 == 2 && u == 0)
                b3 = 2;
            else if (c3 == 2 && f3 == 2 && i3 == 0 && u == 0)
                i3 = 2;
            else if (c3 == 2 && f3 == 0 && i3 == 2 && u == 0)
                f3 = 2;
            else if (c3 == 0 && f3 == 2 && i3 == 2 && u == 0)
                c3 = 2;
            //diagonal win
            else if (a3 == 2 && e3 == 2 && i3 == 0 && u == 0)
                i3 = 2;
            else if (a3 == 2 && e3 == 0 && i3 == 2 && u == 0)
                e3 = 2;
            else if (a3 == 0 && e3 == 2 && i3 == 2 && u == 0)
                a3 = 2;
            else if (c3 == 2 && e3 == 2 && g3 == 0 && u == 0)
                g3 = 2;
            else if (c3 == 2 && e3 == 0 && g3 == 2 && u == 0)
                e3 = 2;
            else if (c3 == 0 && e3 == 2 && g3 == 2 && u == 0)
                c3 = 2;

            // box v
            else if (a4 == 2 && b4 == 2 && c4 == 0 && v == 0)
                c4 = 2;
            else if (a4 == 2 && b4 == 0 && c4 == 2 && v == 0)
                b4 = 2;
            else if (a4 == 0 && b4 == 2 && c4 == 2 && v == 0)
                a4 = 2;
            else if (d4 == 2 && e4 == 2 && f4 == 0 && v == 0)
                f4 = 2;
            else if (d4 == 2 && e4 == 0 && f4 == 2 && v == 0)
                e4 = 2;
            else if (d4 == 0 && e4 == 2 && f4 == 2 && v == 0)
                d4 = 2;
            else if (g4 == 2 && h4 == 2 && i4 == 0 && v == 0)
                i4 = 2;
            else if (g4 == 2 && h4 == 0 && i4 == 2 && v == 0)
                h4 = 2;
            else if (g4 == 0 && h4 == 2 && i4 == 2 && v == 0)
                g4 = 2;
            // vertical win
            else if (a4 == 2 && d4 == 2 && g4 == 0 && v == 0)
                g4 = 2;
            else if (a4 == 2 && d4 == 0 && g4 == 2 && v == 0)
                d4 = 2;
            else if (a4 == 0 && d4 == 2 && g4 == 2 && v == 0)
                a4 = 2;
            else if (b4 == 2 && e4 == 2 && h4 == 0 && v == 0)
                h4 = 2;
            else if (b4 == 2 && e4 == 0 && h4 == 2 && v == 0)
                e4 = 2;
            else if (b4 == 0 && e4 == 2 && h4 == 2 && v == 0)
                b4 = 2;
            else if (c4 == 2 && f4 == 2 && i4 == 0 && v == 0)
                i4 = 2;
            else if (c4 == 2 && f4 == 0 && i4 == 2 && v == 0)
                f4 = 2;
            else if (c4 == 0 && f4 == 2 && i4 == 2 && v == 0)
                c4 = 2;
            //diagonal win
            else if (a4 == 2 && e4 == 2 && i4 == 0 && v == 0)
                i4 = 2;
            else if (a4 == 2 && e4 == 0 && i4 == 2 && v == 0)
                e4 = 2;
            else if (a4 == 0 && e4 == 2 && i4 == 2 && v == 0)
                a4 = 2;
            else if (c4 == 2 && e4 == 2 && g4 == 0 && v == 0)
                g4 = 2;
            else if (c4 == 2 && e4 == 0 && g4 == 2 && v == 0)
                e4 = 2;
            else if (c4 == 0 && e4 == 2 && g4 == 2 && v == 0)
                c4 = 2;

            // box w
            else if (a5 == 2 && b5 == 2 && c5 == 0 && w == 0)
                c5 = 2;
            else if (a5 == 2 && b5 == 0 && c5 == 2 && w == 0)
                b5 = 2;
            else if (a5 == 0 && b5 == 2 && c5 == 2 && w == 0)
                a5 = 2;
            else if (d5 == 2 && e5 == 2 && f5 == 0 && w == 0)
                f5 = 2;
            else if (d5 == 2 && e5 == 0 && f5 == 2 && w == 0)
                e5 = 2;
            else if (d5 == 0 && e5 == 2 && f5 == 2 && w == 0)
                d5 = 2;
            else if (g5 == 2 && h5 == 2 && i5 == 0 && w == 0)
                i5 = 2;
            else if (g5 == 2 && h5 == 0 && i5 == 2 && w == 0)
                h5 = 2;
            else if (g5 == 0 && h5 == 2 && i5 == 2 && w == 0)
                g5 = 2;
            // vertical win
            else if (a5 == 2 && d5 == 2 && g5 == 0 && w == 0)
                g5 = 2;
            else if (a5 == 2 && d5 == 0 && g5 == 2 && w == 0)
                d5 = 2;
            else if (a5 == 0 && d5 == 2 && g5 == 2 && w == 0)
                a5 = 2;
            else if (b5 == 2 && e5 == 2 && h5 == 0 && w == 0)
                h5 = 2;
            else if (b5 == 2 && e5 == 0 && h5 == 2 && w == 0)
                e5 = 2;
            else if (b5 == 0 && e5 == 2 && h5 == 2 && w == 0)
                b5 = 2;
            else if (c5 == 2 && f5 == 2 && i5 == 0 && w == 0)
                i5 = 2;
            else if (c5 == 2 && f5 == 0 && i5 == 2 && w == 0)
                f5 = 2;
            else if (c5 == 0 && f5 == 2 && i5 == 2 && w == 0)
                c5 = 2;
            //diagonal win
            else if (a5 == 2 && e5 == 2 && i5 == 0 && w == 0)
                i5 = 2;
            else if (a5 == 2 && e5 == 0 && i5 == 2 && w == 0)
                e5 = 2;
            else if (a5 == 0 && e5 == 2 && i5 == 2 && w == 0)
                a5 = 2;
            else if (c5 == 2 && e5 == 2 && g5 == 0 && w == 0)
                g5 = 2;
            else if (c5 == 2 && e5 == 0 && g5 == 2 && w == 0)
                e5 = 2;
            else if (c5 == 0 && e5 == 2 && g5 == 2 && w == 0)
                c5 = 2;

            // box x1
            else if (a6 == 2 && b6 == 2 && c6 == 0 && x1 == 0)
                c6 = 2;
            else if (a6 == 2 && b6 == 0 && c6 == 2 && x1 == 0)
                b6 = 2;
            else if (a6 == 0 && b6 == 2 && c6 == 2 && x1 == 0)
                a6 = 2;
            else if (d6 == 2 && e6 == 2 && f6 == 0 && x1 == 0)
                f6 = 2;
            else if (d6 == 2 && e6 == 0 && f6 == 2 && x1 == 0)
                e6 = 2;
            else if (d6 == 0 && e6 == 2 && f6 == 2 && x1 == 0)
                d6 = 2;
            else if (g6 == 2 && h6 == 2 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (g6 == 2 && h6 == 0 && i6 == 2 && x1 == 0)
                h6 = 2;
            else if (g6 == 0 && h6 == 2 && i6 == 2 && x1 == 0)
                g6 = 2;
            // vertical win
            else if (a6 == 2 && d6 == 2 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (a6 == 2 && d6 == 0 && g6 == 2 && x1 == 0)
                d6 = 2;
            else if (a6 == 0 && d6 == 2 && g6 == 2 && x1 == 0)
                a6 = 2;
            else if (b6 == 2 && e6 == 2 && h6 == 0 && x1 == 0)
                h6 = 2;
            else if (b6 == 2 && e6 == 0 && h6 == 2 && x1 == 0)
                e6 = 2;
            else if (b6 == 0 && e6 == 2 && h6 == 2 && x1 == 0)
                b6 = 2;
            else if (c6 == 2 && f6 == 2 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (c6 == 2 && f6 == 0 && i6 == 2 && x1 == 0)
                f6 = 2;
            else if (c6 == 0 && f6 == 2 && i6 == 2 && x1 == 0)
                c6 = 2;
            //diagonal win
            else if (a6 == 2 && e6 == 2 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (a6 == 2 && e6 == 0 && i6 == 2 && x1 == 0)
                e6 = 2;
            else if (a6 == 0 && e6 == 2 && i6 == 2 && x1 == 0)
                a6 = 2;
            else if (c6 == 2 && e6 == 2 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (c6 == 2 && e6 == 0 && g6 == 2 && x1 == 0)
                e6 = 2;
            else if (c6 == 0 && e6 == 2 && g6 == 2 && x1 == 0)
                c6 = 2;

            // box y1
            else if (a7 == 2 && b7 == 2 && c7 == 0 && y1 == 0)
                c7 = 2;
            else if (a7 == 2 && b7 == 0 && c7 == 2 && y1 == 0)
                b7 = 2;
            else if (a7 == 0 && b7 == 2 && c7 == 2 && y1 == 0)
                a7 = 2;
            else if (d7 == 2 && e7 == 2 && f7 == 0 && y1 == 0)
                f7 = 2;
            else if (d7 == 2 && e7 == 0 && f7 == 2 && y1 == 0)
                e7 = 2;
            else if (d7 == 0 && e7 == 2 && f7 == 2 && y1 == 0)
                d7 = 2;
            else if (g7 == 2 && h7 == 2 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (g7 == 2 && h7 == 0 && i7 == 2 && y1 == 0)
                h7 = 2;
            else if (g7 == 0 && h7 == 2 && i7 == 2 && y1 == 0)
                g7 = 2;
            // vertical win
            else if (a7 == 2 && d7 == 2 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (a7 == 2 && d7 == 0 && g7 == 2 && y1 == 0)
                d7 = 2;
            else if (a7 == 0 && d7 == 2 && g7 == 2 && y1 == 0)
                a7 = 2;
            else if (b7 == 2 && e7 == 2 && h7 == 0 && y1 == 0)
                h7 = 2;
            else if (b7 == 2 && e7 == 0 && h7 == 2 && y1 == 0)
                e7 = 2;
            else if (b7 == 0 && e7 == 2 && h7 == 2 && y1 == 0)
                b7 = 2;
            else if (c7 == 2 && f7 == 2 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (c7 == 2 && f7 == 0 && i7 == 2 && y1 == 0)
                f7 = 2;
            else if (c7 == 0 && f7 == 2 && i7 == 2 && y1 == 0)
                c7 = 2;
            //diagonal win
            else if (a7 == 2 && e7 == 2 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (a7 == 2 && e7 == 0 && i7 == 2 && y1 == 0)
                e7 = 2;
            else if (a7 == 0 && e7 == 2 && i7 == 2 && y1 == 0)
                a7 = 2;
            else if (c7 == 2 && e7 == 2 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (c7 == 2 && e7 == 0 && g7 == 2 && y1 == 0)
                e7 = 2;
            else if (c7 == 0 && e7 == 2 && g7 == 2 && y1 == 0)
                c7 = 2;

            // box z
            else if (a8 == 2 && b8 == 2 && c8 == 0 && z == 0)
                c8 = 2;
            else if (a8 == 2 && b8 == 0 && c8 == 2 && z == 0)
                b8 = 2;
            else if (a8 == 0 && b8 == 2 && c8 == 2 && z == 0)
                a8 = 2;
            else if (d8 == 2 && e8 == 2 && f8 == 0 && z == 0)
                f8 = 2;
            else if (d8 == 2 && e8 == 0 && f8 == 2 && z == 0)
                e8 = 2;
            else if (d8 == 0 && e8 == 2 && f8 == 2 && z == 0)
                d8 = 2;
            else if (g8 == 2 && h8 == 2 && i8 == 0 && z == 0)
                i8 = 2;
            else if (g8 == 2 && h8 == 0 && i8 == 2 && z == 0)
                h8 = 2;
            else if (g8 == 0 && h8 == 2 && i8 == 2 && z == 0)
                g8 = 2;
            // vertical win
            else if (a8 == 2 && d8 == 2 && g8 == 0 && z == 0)
                g8 = 2;
            else if (a8 == 2 && d8 == 0 && g8 == 2 && z == 0)
                d8 = 2;
            else if (a8 == 0 && d8 == 2 && g8 == 2 && z == 0)
                a8 = 2;
            else if (b8 == 2 && e8 == 2 && h8 == 0 && z == 0)
                h8 = 2;
            else if (b8 == 2 && e8 == 0 && h8 == 2 && z == 0)
                e8 = 2;
            else if (b8 == 0 && e8 == 2 && h8 == 2 && z == 0)
                b8 = 2;
            else if (c8 == 2 && f8 == 2 && i8 == 0 && z == 0)
                i8 = 2;
            else if (c8 == 2 && f8 == 0 && i8 == 2 && z == 0)
                f8 = 2;
            else if (c8 == 0 && f8 == 2 && i8 == 2 && z == 0)
                c8 = 2;
            //diagonal win
            else if (a8 == 2 && e8 == 2 && i8 == 0 && z == 0)
                i8 = 2;
            else if (a8 == 2 && e8 == 0 && i8 == 2 && z == 0)
                e8 = 2;
            else if (a8 == 0 && e8 == 2 && i8 == 2 && z == 0)
                a8 = 2;
            else if (c8 == 2 && e8 == 2 && g8 == 0 && z == 0)
                g8 = 2;
            else if (c8 == 2 && e8 == 0 && g8 == 2 && z == 0)
                e8 = 2;
            else if (c8 == 0 && e8 == 2 && g8 == 2 && z == 0)
                c8 = 2;

            //defensive moves

            // box r
            // horizontal blocking
            else if (a == 1 && b == 1 && c == 0 && r == 0)
                c = 2;
            else if (a == 1 && b == 0 && c == 1 && r == 0)
                b = 2;
            else if (a == 0 && b == 1 && c == 1 && r == 0)
                a = 2;
            else if (d == 1 && e1 == 1 && f == 0 && r == 0)
                f = 2;
            else if (d == 1 && e1 == 0 && f == 1 && r == 0)
                e1 = 2;
            else if (d == 0 && e1 == 1 && f == 1 && r == 0)
                d = 2;
            else if (g1 == 1 && h == 1 && i == 0 && r == 0)
                i = 2;
            else if (g1 == 1 && h == 0 && i == 1 && r == 0)
                h = 2;
            else if (g1 == 0 && h == 1 && i == 1 && r == 0)
                g1 = 2;
            // vertical blocking
            else if (a == 1 && d == 1 && g1 == 0 && r == 0)
                g1 = 2;
            else if (a == 1 && d == 0 && g1 == 1 && r == 0)
                d = 2;
            else if (a == 0 && d == 1 && g1 == 1 && r == 0)
                a = 2;
            else if (b == 1 && e1 == 1 && h == 0 && r == 0)
                h = 2;
            else if (b == 1 && e1 == 0 && h == 1 && r == 0)
                e1 = 2;
            else if (b == 0 && e1 == 1 && h == 1 && r == 0)
                b = 2;
            else if (c == 1 && f == 1 && i == 0 && r == 0)
                i = 2;
            else if (c == 1 && f == 0 && i == 1 && r == 0)
                f = 2;
            else if (c == 0 && f == 1 && i == 1 && r == 0)
                c = 2;
            //diagonal blocking
            else if (a == 1 && e1 == 1 && i == 0 && r == 0)
                i = 2;
            else if (a == 1 && e1 == 0 && i == 1 && r == 0)
                e1 = 2;
            else if (a == 0 && e1 == 1 && i == 1 && r == 0)
                a = 2;
            else if (c == 1 && e1 == 1 && g1 == 0 && r == 0)
                g1 = 2;
            else if (c == 1 && e1 == 0 && g1 == 1 && r == 0)
                e1 = 2;
            else if (c == 0 && e1 == 1 && g1 == 1 && r == 0)
                c = 2;
            // box s
            // horizontal blocking
            else if (a1 == 1 && b1 == 1 && c1 == 0 && s == 0)
                c1 = 2;
            else if (a1 == 1 && b1 == 0 && c1 == 1 && s == 0)
                b1 = 2;
            else if (a1 == 0 && b1 == 1 && c1 == 1 && s == 0)
                a1 = 2;
            else if (d1 == 1 && e11 == 1 && f1 == 0 && s == 0)
                f1 = 2;
            else if (d1 == 1 && e11 == 0 && f1 == 1 && s == 0)
                e11 = 2;
            else if (d1 == 0 && e11 == 1 && f1 == 1 && s == 0)
                d1 = 2;
            else if (g11 == 1 && h1 == 1 && i1 == 0 && s == 0)
                i1 = 2;
            else if (g11 == 1 && h1 == 0 && i1 == 1 && s == 0)
                h1 = 2;
            else if (g11 == 0 && h1 == 1 && i1 == 1 && s == 0)
                g11 = 2;
            // vertical blocking
            else if (a1 == 1 && d1 == 1 && g11 == 0 && s == 0)
                g11 = 2;
            else if (a1 == 1 && d1 == 0 && g11 == 1 && s == 0)
                d1 = 2;
            else if (a1 == 0 && d1 == 1 && g11 == 1 && s == 0)
                a1 = 2;
            else if (b1 == 1 && e11 == 1 && h1 == 0 && s == 0)
                h1 = 2;
            else if (b1 == 1 && e11 == 0 && h1 == 1 && s == 0)
                e11 = 2;
            else if (b1 == 0 && e11 == 1 && h1 == 1 && s == 0)
                b1 = 2;
            else if (c1 == 1 && f1 == 1 && i1 == 0 && s == 0)
                i1 = 2;
            else if (c1 == 1 && f1 == 0 && i1 == 1 && s == 0)
                f1 = 2;
            else if (c1 == 0 && f1 == 1 && i1 == 1 && s == 0)
                c1 = 2;
            //diagonal blocking
            else if (a1 == 1 && e11 == 1 && i1 == 0 && s == 0)
                i1 = 2;
            else if (a1 == 1 && e11 == 0 && i1 == 1 && s == 0)
                e11 = 2;
            else if (a1 == 0 && e11 == 1 && i1 == 1 && s == 0)
                a1 = 2;
            else if (c1 == 1 && e11 == 1 && g11 == 0 && s == 0)
                g11 = 2;
            else if (c1 == 1 && e11 == 0 && g11 == 1 && s == 0)
                e11 = 2;
            else if (c1 == 0 && e11 == 1 && g11 == 1 && s == 0)
                c1 = 2;
            // box t
            // horizontal blocking
            else if (a2 == 1 && b2 == 1 && c2 == 0 && t == 0)
                c2 = 2;
            else if (a2 == 1 && b2 == 0 && c2 == 1 && t == 0)
                b2 = 2;
            else if (a2 == 0 && b2 == 1 && c2 == 1 && t == 0)
                a2 = 2;
            else if (d2 == 1 && e2 == 1 && f2 == 0 && t == 0)
                f2 = 2;
            else if (d2 == 1 && e2 == 0 && f2 == 1 && t == 0)
                e2 = 2;
            else if (d2 == 0 && e2 == 1 && f2 == 1 && t == 0)
                d2 = 2;
            else if (g2 == 1 && h2 == 1 && i2 == 0 && t == 0)
                i2 = 2;
            else if (g2 == 1 && h2 == 0 && i2 == 1 && t == 0)
                h2 = 2;
            else if (g2 == 0 && h2 == 1 && i2 == 1 && t == 0)
                g2 = 2;
            // vertical blocking
            else if (a2 == 1 && d2 == 1 && g2 == 0 && t == 0)
                g2 = 2;
            else if (a2 == 1 && d2 == 0 && g2 == 1 && t == 0)
                d2 = 2;
            else if (a2 == 0 && d2 == 1 && g2 == 1 && t == 0)
                a2 = 2;
            else if (b2 == 1 && e2 == 1 && h2 == 0 && t == 0)
                h2 = 2;
            else if (b2 == 1 && e2 == 0 && h2 == 1 && t == 0)
                e2 = 2;
            else if (b2 == 0 && e2 == 1 && h2 == 1 && t == 0)
                b2 = 2;
            else if (c2 == 1 && f2 == 1 && i2 == 0 && t == 0)
                i2 = 2;
            else if (c2 == 1 && f2 == 0 && i2 == 1 && t == 0)
                f2 = 2;
            else if (c2 == 0 && f2 == 1 && i2 == 1 && t == 0)
                c2 = 2;
            //diagonal blocking
            else if (a2 == 1 && e2 == 1 && i2 == 0 && t == 0)
                i2 = 2;
            else if (a2 == 1 && e2 == 0 && i2 == 1 && t == 0)
                e2 = 2;
            else if (a2 == 0 && e2 == 1 && i2 == 1 && t == 0)
                a2 = 2;
            else if (c2 == 1 && e2 == 1 && g2 == 0 && t == 0)
                g2 = 2;
            else if (c2 == 1 && e2 == 0 && g2 == 1 && t == 0)
                e2 = 2;
            else if (c2 == 0 && e2 == 1 && g2 == 1 && t == 0)
                c2 = 2;
            // box u
            // horizontal blocking
            else if (a3 == 1 && b3 == 1 && c3 == 0 && u == 0)
                c3 = 2;
            else if (a3 == 1 && b3 == 0 && c3 == 1 && u == 0)
                b3 = 2;
            else if (a3 == 0 && b3 == 1 && c3 == 1 && u == 0)
                a3 = 2;
            else if (d3 == 1 && e3 == 1 && f3 == 0 && u == 0)
                f3 = 2;
            else if (d3 == 1 && e3 == 0 && f3 == 1 && u == 0)
                e3 = 2;
            else if (d3 == 0 && e3 == 1 && f3 == 1 && u == 0)
                d3 = 2;
            else if (g3 == 1 && h3 == 1 && i3 == 0 && u == 0)
                i3 = 2;
            else if (g3 == 1 && h3 == 0 && i3 == 1 && u == 0)
                h3 = 2;
            else if (g3 == 0 && h3 == 1 && i3 == 1 && u == 0)
                g3 = 2;
            // vertical blocking
            else if (a3 == 1 && d3 == 1 && g3 == 0 && u == 0)
                g3 = 2;
            else if (a3 == 1 && d3 == 0 && g3 == 1 && u == 0)
                d3 = 2;
            else if (a3 == 0 && d3 == 1 && g3 == 1 && u == 0)
                a3 = 2;
            else if (b3 == 1 && e3 == 1 && h3 == 0 && u == 0)
                h3 = 2;
            else if (b3 == 1 && e3 == 0 && h3 == 1 && u == 0)
                e3 = 2;
            else if (b3 == 0 && e3 == 1 && h3 == 1 && u == 0)
                b3 = 2;
            else if (c3 == 1 && f3 == 1 && i3 == 0 && u == 0)
                i3 = 2;
            else if (c3 == 1 && f3 == 0 && i3 == 1 && u == 0)
                f3 = 2;
            else if (c3 == 0 && f3 == 1 && i3 == 1 && u == 0)
                c3 = 2;
            //diagonal blocking
            else if (a3 == 1 && e3 == 1 && i3 == 0 && u == 0)
                i3 = 2;
            else if (a3 == 1 && e3 == 0 && i3 == 1 && u == 0)
                e3 = 2;
            else if (a3 == 0 && e3 == 1 && i3 == 1 && u == 0)
                a3 = 2;
            else if (c3 == 1 && e3 == 1 && g3 == 0 && u == 0)
                g3 = 2;
            else if (c3 == 1 && e3 == 0 && g3 == 1 && u == 0)
                e3 = 2;
            else if (c3 == 0 && e3 == 1 && g3 == 1 && u == 0)
                c3 = 2;
            // box v
            // horizontal blocking
            else if (a4 == 1 && b4 == 1 && c4 == 0 && v == 0)
                c4 = 2;
            else if (a4 == 1 && b4 == 0 && c4 == 1 && v == 0)
                b4 = 2;
            else if (a4 == 0 && b4 == 1 && c4 == 1 && v == 0)
                a4 = 2;
            else if (d4 == 1 && e4 == 1 && f4 == 0 && v == 0)
                f4 = 2;
            else if (d4 == 1 && e4 == 0 && f4 == 1 && v == 0)
                e4 = 2;
            else if (d4 == 0 && e4 == 1 && f4 == 1 && v == 0)
                d4 = 2;
            else if (g4 == 1 && h4 == 1 && i4 == 0 && v == 0)
                i4 = 2;
            else if (g4 == 1 && h4 == 0 && i4 == 1 && v == 0)
                h4 = 2;
            else if (g4 == 0 && h4 == 1 && i4 == 1 && v == 0)
                g4 = 2;
            // vertical blocking
            else if (a4 == 1 && d4 == 1 && g4 == 0 && v == 0)
                g4 = 2;
            else if (a4 == 1 && d4 == 0 && g4 == 1 && v == 0)
                d4 = 2;
            else if (a4 == 0 && d4 == 1 && g4 == 1 && v == 0)
                a4 = 2;
            else if (b4 == 1 && e4 == 1 && h4 == 0 && v == 0)
                h4 = 2;
            else if (b4 == 1 && e4 == 0 && h4 == 1 && v == 0)
                e4 = 2;
            else if (b4 == 0 && e4 == 1 && h4 == 1 && v == 0)
                b4 = 2;
            else if (c4 == 1 && f4 == 1 && i4 == 0 && v == 0)
                i4 = 2;
            else if (c4 == 1 && f4 == 0 && i4 == 1 && v == 0)
                f4 = 2;
            else if (c4 == 0 && f4 == 1 && i4 == 1 && v == 0)
                c4 = 2;
            //diagonal blocking
            else if (a4 == 1 && e4 == 1 && i4 == 0 && v == 0)
                i4 = 2;
            else if (a4 == 1 && e4 == 0 && i4 == 1 && v == 0)
                e4 = 2;
            else if (a4 == 0 && e4 == 1 && i4 == 1 && v == 0)
                a4 = 2;
            else if (c4 == 1 && e4 == 1 && g4 == 0 && v == 0)
                g4 = 2;
            else if (c4 == 1 && e4 == 0 && g4 == 1 && v == 0)
                e1 = 2;
            else if (c4 == 0 && e4 == 1 && g4 == 1 && v == 0)
                c4 = 2;
            // box w
            // horizontal blocking
            else if (a5 == 1 && b5 == 1 && c5 == 0 && w == 0)
                c5 = 2;
            else if (a5 == 1 && b5 == 0 && c5 == 1 && w == 0)
                b5 = 2;
            else if (a5 == 0 && b5 == 1 && c5 == 1 && w == 0)
                a5 = 2;
            else if (d5 == 1 && e5 == 1 && f5 == 0 && w == 0)
                f5 = 2;
            else if (d5 == 1 && e5 == 0 && f5 == 1 && w == 0)
                e5 = 2;
            else if (d5 == 0 && e5 == 1 && f5 == 1 && w == 0)
                d5 = 2;
            else if (g5 == 1 && h5 == 1 && i5 == 0 && w == 0)
                i5 = 2;
            else if (g5 == 1 && h5 == 0 && i5 == 1 && w == 0)
                h5 = 2;
            else if (g5 == 0 && h5 == 1 && i5 == 1 && w == 0)
                g5 = 2;
            // vertical blocking
            else if (a5 == 1 && d5 == 1 && g5 == 0 && w == 0)
                g5 = 2;
            else if (a5 == 1 && d5 == 0 && g5 == 1 && w == 0)
                d5 = 2;
            else if (a5 == 0 && d5 == 1 && g5 == 1 && w == 0)
                a5 = 2;
            else if (b5 == 1 && e5 == 1 && h5 == 0 && w == 0)
                h5 = 2;
            else if (b5 == 1 && e5 == 0 && h5 == 1 && w == 0)
                e5 = 2;
            else if (b5 == 0 && e5 == 1 && h5 == 1 && w == 0)
                b5 = 2;
            else if (c5 == 1 && f5 == 1 && i5 == 0 && w == 0)
                i5 = 2;
            else if (c5 == 1 && f5 == 0 && i5 == 1 && w == 0)
                f5 = 2;
            else if (c5 == 0 && f5 == 1 && i5 == 1 && w == 0)
                c5 = 2;
            //diagonal blocking
            else if (a5 == 1 && e5 == 1 && i5 == 0 && w == 0)
                i5 = 2;
            else if (a5 == 1 && e5 == 0 && i5 == 1 && w == 0)
                e5 = 2;
            else if (a5 == 0 && e5 == 1 && i5 == 1 && w == 0)
                a5 = 2;
            else if (c5 == 1 && e5 == 1 && g5 == 0 && w == 0)
                g5 = 2;
            else if (c5 == 1 && e5 == 0 && g5 == 1 && w == 0)
                e5 = 2;
            else if (c5 == 0 && e5 == 1 && g5 == 1 && w == 0)
                c5 = 2;
            // box x1
            // horizontal blocking
            else if (a6 == 1 && b6 == 1 && c6 == 0 && x1 == 0)
                c6 = 2;
            else if (a6 == 1 && b6 == 0 && c6 == 1 && x1 == 0)
                b6 = 2;
            else if (a6 == 0 && b6 == 1 && c6 == 1 && x1 == 0)
                a6 = 2;
            else if (d6 == 1 && e6 == 1 && f6 == 0 && x1 == 0)
                f6 = 2;
            else if (d6 == 1 && e6 == 0 && f6 == 1 && x1 == 0)
                e6 = 2;
            else if (d6 == 0 && e6 == 1 && f6 == 1 && x1 == 0)
                d6 = 2;
            else if (g6 == 1 && h6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (g6 == 1 && h6 == 0 && i6 == 1 && x1 == 0)
                h6 = 2;
            else if (g6 == 0 && h6 == 1 && i6 == 1 && x1 == 0)
                g6 = 2;
            // vertical blocking
            else if (a6 == 1 && d6 == 1 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (a6 == 1 && d6 == 0 && g6 == 1 && x1 == 0)
                d6 = 2;
            else if (a6 == 0 && d6 == 1 && g6 == 1 && x1 == 0)
                a6 = 2;
            else if (b6 == 1 && e6 == 1 && h6 == 0 && x1 == 0)
                h6 = 2;
            else if (b6 == 1 && e6 == 0 && h6 == 1 && x1 == 0)
                e6 = 2;
            else if (b6 == 0 && e6 == 1 && h6 == 1 && x1 == 0)
                b6 = 2;
            else if (c6 == 1 && f6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (c6 == 1 && f6 == 0 && i6 == 1 && x1 == 0)
                f6 = 2;
            else if (c6 == 0 && f6 == 1 && i6 == 1 && x1 == 0)
                c6 = 2;
            //diagonal blocking
            else if (a6 == 1 && e6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (a6 == 1 && e6 == 0 && i6 == 1 && x1 == 0)
                e6 = 2;
            else if (a6 == 0 && e6 == 1 && i6 == 1 && x1 == 0)
                a6 = 2;
            else if (c6 == 1 && e6 == 1 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (c6 == 1 && e6 == 0 && g6 == 1 && x1 == 0)
                e6 = 2;
            else if (c6 == 0 && e6 == 1 && g6 == 1 && x1 == 0)
                c6 = 2;
            // box y1
            // horizontal blocking
            else if (a7 == 1 && b7 == 1 && c7 == 0 && y1 == 0)
                c7 = 2;
            else if (a7 == 1 && b7 == 0 && c7 == 1 && y1 == 0)
                b7 = 2;
            else if (a7 == 0 && b7 == 1 && c7 == 1 && y1 == 0)
                a7 = 2;
            else if (d7 == 1 && e7 == 1 && f7 == 0 && y1 == 0)
                f7 = 2;
            else if (d7 == 1 && e7 == 0 && f7 == 1 && y1 == 0)
                e7 = 2;
            else if (d7 == 0 && e7 == 1 && f7 == 1 && y1 == 0)
                d7 = 2;
            else if (g7 == 1 && h7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (g7 == 1 && h7 == 0 && i7 == 1 && y1 == 0)
                h7 = 2;
            else if (g7 == 0 && h7 == 1 && i7 == 1 && y1 == 0)
                g7 = 2;
            // vertical blocking
            else if (a7 == 1 && d7 == 1 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (a7 == 1 && d7 == 0 && g7 == 1 && y1 == 0)
                d7 = 2;
            else if (a7 == 0 && d7 == 1 && g7 == 1 && y1 == 0)
                a7 = 2;
            else if (b7 == 1 && e7 == 1 && h7 == 0 && y1 == 0)
                h7 = 2;
            else if (b7 == 1 && e7 == 0 && h7 == 1 && y1 == 0)
                e7 = 2;
            else if (b7 == 0 && e7 == 1 && h7 == 1 && y1 == 0)
                b7 = 2;
            else if (c7 == 1 && f7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (c7 == 1 && f7 == 0 && i7 == 1 && y1 == 0)
                f7 = 2;
            else if (c7 == 0 && f7 == 1 && i7 == 1 && y1 == 0)
                c7 = 2;
            //diagonal blocking
            else if (a7 == 1 && e7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (a7 == 1 && e7 == 0 && i7 == 1 && y1 == 0)
                e7 = 2;
            else if (a7 == 0 && e7 == 1 && i7 == 1 && y1 == 0)
                a7 = 2;
            else if (c7 == 1 && e7 == 1 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (c7 == 1 && e7 == 0 && g7 == 1 && y1 == 0)
                e7 = 2;
            else if (c7 == 0 && e7 == 1 && g7 == 1 && y1 == 0)
                c7 = 2; 
            // box z
            // horizontal blocking
            else if (a8 == 1 && b8 == 1 && c8 == 0 && z == 0)
                c8 = 2;
            else if (a8 == 1 && b8 == 0 && c8 == 1 && z == 0)
                b8 = 2;
            else if (a8 == 0 && b8 == 1 && c8 == 1 && z == 0)
                a8 = 2;
            else if (d8 == 1 && e8 == 1 && f8 == 0 && z == 0)
                f8 = 2;
            else if (d8 == 1 && e8 == 0 && f8 == 1 && z == 0)
                e8 = 2;
            else if (d8 == 0 && e8 == 1 && f8 == 1 && z == 0)
                d8 = 2;
            else if (g8 == 1 && h8 == 1 && i8 == 0 && z == 0)
                i8 = 2;
            else if (g8 == 1 && h8 == 0 && i8 == 1 && z == 0)
                h8 = 2;
            else if (g8 == 0 && h8 == 1 && i8 == 1 && z == 0)
                g8 = 2;
            // vertical blocking
            else if (a8 == 1 && d8 == 1 && g8 == 0 && z == 0)
                g8 = 2;
            else if (a8 == 1 && d8 == 0 && g8 == 1 && z == 0)
                d8 = 2;
            else if (a8 == 0 && d8 == 1 && g8 == 1 && z == 0)
                a8 = 2;
            else if (b8 == 1 && e8 == 1 && h8 == 0 && z == 0)
                h8 = 2;
            else if (b8 == 1 && e8 == 0 && h8 == 1 && z == 0)
                e8 = 2;
            else if (b8 == 0 && e8 == 1 && h8 == 1 && z == 0)
                b8 = 2;
            else if (c8 == 1 && f8 == 1 && i8 == 0 && z == 0)
                i8 = 2;
            else if (c8 == 1 && f8 == 0 && i8 == 1 && z == 0)
                f8 = 2;
            else if (c8 == 0 && f8 == 1 && i8 == 1 && z == 0)
                c8 = 2;
            //diagonal blocking
            else if (a8 == 1 && e8 == 1 && i8 == 0 && z == 0)
                i8 = 2;
            else if (a8 == 1 && e8 == 0 && i8 == 1 && z == 0)
                e8 = 2;
            else if (a8 == 0 && e8 == 1 && i8 == 1 && z == 0)
                a8 = 2;
            else if (c8 == 1 && e8 == 1 && g8 == 0 && z == 0)
                g8 = 2;
            else if (c8 == 1 && e8 == 0 && g8 == 1 && z == 0)
                e8 = 2;
            else if (c8 == 0 && e8 == 1 && g8 == 1 && z == 0)
                c8 = 2;

            // first move (takes middle of whatever square player 1 clicked in)
            else if ((a == 1 || c == 1 || g1 == 1 || i == 1 || b == 1 || d == 1 || f == 1 || h == 1) && e1 == 0 && r == 0)
                e1 = 2;
            else if ((a1 == 1 || c1 == 1 || g11 == 1 || i1 == 1|| b1 == 1 || d1 == 1 || f1 == 1 || h1 == 1) && e11 == 0 && s == 0)
                e11 = 2;
            else if ((a2 == 1 || c2 == 1 || g2 == 1 || i2 == 1|| b2 == 1 || d2 == 1 || f2 == 1 || h2 == 1) && e2 == 0 && t == 0)
                e2 = 2;
            else if ((a3 == 1 || c3 == 1 || g3 == 1 || i3 == 1|| b3 == 1 || d3 == 1 || f3 == 1 || h3 == 1) && e3 == 0 && u == 0)
                e3 = 2;
            else if ((a4 == 1 || c4 == 1 || g4 == 1 || i4 == 1|| b4 == 1 || d4 == 1 || f4 == 1 || h4 == 1) && e4 == 0 && v == 0)
                e4 = 2;
            else if ((a5 == 1 || c5 == 1 || g5 == 1 || i5 == 1|| b5 == 1 || d5 == 1 || f5 == 1 || h5 == 1) && e5 == 0 && w == 0)
                e5 = 2;
            else if ((a6 == 1 || c6 == 1 || g6 == 1 || i6 == 1|| b6 == 1 || d6 == 1 || f6 == 1 || h6 == 1) && e6 == 0 && x1 == 0)
                e6 = 2;
            else if ((a7 == 1 || c7 == 1 || g7 == 1 || i7 == 1|| b7 == 1 || d7 == 1 || f7 == 1 || h7 == 1) && e7 == 0 && y1 == 0)
                e7 = 2;
            else if ((a8 == 1 || c8 == 1 || g8 == 1 || i8 == 1|| b8 == 1 || d8 == 1 || f8 == 1 || h8 == 1) && e8 == 0 && z == 0)
                e8 = 2;
            // if middle is taken
            else if (e1 == 1 && a == 0 && c == 0 && g1 == 0 && i == 0 && r == 0) // picks a random corner for move 1
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a = 2;
                else if (corner == 2)
                    c = 2;
                else if (corner == 3)
                    g1 = 2;
                else if (corner == 4)
                    i = 2;
            }
            else if (e11 == 1 && a1 == 0 && c1 == 0 && g11 == 0 && i1 == 0 && s == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a1 = 2;
                else if (corner == 2)
                    c1 = 2;
                else if (corner == 3)
                    g11 = 2;
                else if (corner == 4)
                    i1 = 2;
            }
            else if (e2 == 1 && a2 == 0 && c2 == 0 && g2 == 0 && i2 == 0 && t == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a2 = 2;
                else if (corner == 2)
                    c2 = 2;
                else if (corner == 3)
                    g2 = 2;
                else if (corner == 4)
                    i2 = 2;
            }
            else if (e3 == 1 && a3 == 0 && c3 == 0 && g3 == 0 && i3 == 0 && u == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a3 = 2;
                else if (corner == 2)
                    c3 = 2;
                else if (corner == 3)
                    g3 = 2;
                else if (corner == 4)
                    i3 = 2;
            }
            else if (e4 == 1 && a4 == 0 && c4 == 0 && g4 == 0 && i4 == 0 && v == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a4 = 2;
                else if (corner == 2)
                    c4 = 2;
                else if (corner == 3)
                    g4 = 2;
                else if (corner == 4)
                    i4 = 2;
            }
            else if (e5 == 1 && a5 == 0 && c5 == 0 && g5 == 0 && i5 == 0 && w == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a5 = 2;
                else if (corner == 2)
                    c5 = 2;
                else if (corner == 3)
                    g5 = 2;
                else if (corner == 4)
                    i5 = 2;
            }
            else if (e6 == 1 && a6 == 0 && c6 == 0 && g6 == 0 && i6 == 0 && x1 == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a6 = 2;
                else if (corner == 2)
                    c6 = 2;
                else if (corner == 3)
                    g6 = 2;
                else if (corner == 4)
                    i6 = 2;
            }
            else if (e7 == 1 && a7 == 0 && c7 == 0 && g7 == 0 && i7 == 0 && y1 == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a7 = 2;
                else if (corner == 2)
                    c7 = 2;
                else if (corner == 3)
                    g7 = 2;
                else if (corner == 4)
                    i7 = 2;
            }
            else if (e8 == 1 && a8 == 0 && c8 == 0 && g8 == 0 && i8 == 0 && z == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a8 = 2;
                else if (corner == 2)
                    c8 = 2;
                else if (corner == 3)
                    g8 = 2;
                else if (corner == 4)
                    i8 = 2;
            }

            // other scenarios
            //box r
            //diagonal line (no two in a row)
            else if (a == 2 && e1 == 1 && i == 1 && g1 == 0 && r == 0)
                g1 = 2;
            else if (c == 2 && e1 == 1 && g1 == 1 && a == 0 && r == 0)
                a = 2;
            else if (i == 2 && e1 == 1 && a == 1 && c == 0 && r == 0)
                c = 2;
            else if (g1 == 2 && e1 == 1 && c == 1 && i == 0 && r == 0)
                i = 2;
            else if (a == 1 && i == 1 && d == 0 && r == 0)
                d = 2;
            else if (c == 1 && g1 == 1 && f == 0 && r == 0)
                f = 2;
            // T scenario
            else if (a == 1 && c == 1 && h == 1 && e1 == 2 && b == 2 && d == 0 && r == 0)
                d = 2;
            else if (c == 1 && i == 1 && d == 1 && e1 == 2 && f == 2 &&  b == 0 && r == 0)
                b = 2;
            else if (b == 1 && g1 == 1 && i == 1 && e1 == 2 && h == 2 && f == 0 && r == 0)
                f = 2;
            else if (a == 1 && g1 == 1 && f == 1 && e1 == 2 && d == 2 && h == 0 && r == 0)
                h = 2;
            // reverse T / H scenario
            else if (a == 2 && c == 2 && h == 2 && e1 == 1 && b == 1 && d == 0 && r == 0)
                d = 2;
            else if (c == 2 && i == 2 && d == 2 && e1 == 1 && f == 1 &&  b == 0 && r == 0)
                b = 2;
            else if (b == 2 && g1 == 2 && i == 2 && e1 == 1 && h == 1 && f == 0 && r == 0)
                f = 2;
            else if (a == 2 && g1 == 2 && f == 2 && e1 == 1 && d == 1 && h == 0 && r == 0)
                h = 2;
            // one corner and a side
            else if (a == 1 && e1 == 2 && f == 1 && c == 0 && r == 0)
                c = 2;
            else if (a == 1 && e1 == 2 && h == 1 && g1 == 0 && r == 0)
                g1 = 2;
            else if (c == 1 && e1 == 2 && h == 1 && i == 0 && r == 0)
                i = 2;
            else if (c == 1 && e1 == 2 && d == 1 && a == 0 && r == 0)
                a = 2;
            else if (i == 1 && e1 == 2 && d == 1 && g1 == 0 && r == 0)
                g1 = 2;
            else if (i == 1 && e1 == 2 && b == 1 && c == 0 && r == 0)
                c = 2;
            else if (g1 == 1 && e1 == 2 && b == 1 && a == 0 && r == 0)
                a = 2;
            else if (g1 == 1 && e1 == 2 && f == 1 && i == 0 && r == 0)
                i = 2;

            //box s
            //diagonal line (no two in a row)
            else if (a1 == 2 && e11 == 1 && i1 == 1 && g11 == 0 && s == 0)
                g11 = 2;
            else if (c1 == 2 && e11 == 1 && g11 == 1 && a1 == 0 && s == 0)
                a1 = 2;
            else if (i1 == 2 && e11 == 1 && a1 == 1 && c1 == 0 && s == 0)
                c1 = 2;
            else if (g11 == 2 && e11 == 1 && c1 == 1 && i1 == 0 && s == 0)
                i1 = 2;
            else if (a1 == 1 && i1 == 1 && d1 == 0 && s == 0)
                d1 = 2;
            else if (c1 == 1 && g11 == 1 && f1 == 0 && s == 0)
                f1 = 2;
            // T scenario
            else if (a1 == 1 && c1 == 1 && h1 == 1 && e11 == 2 && b1 == 2 && d1 == 0 && s == 0)
                d1 = 2;
            else if (c1 == 1 && i1 == 1 && d1 == 1 && e11 == 2 && f1 == 2 &&  b1 == 0 && s == 0)
                b1 = 2;
            else if (b1 == 1 && g11 == 1 && i1 == 1 && e11 == 2 && h1 == 2 && f1 == 0 && s == 0)
                f1 = 2;
            else if (a1 == 1 && g11 == 1 && f1 == 1 && e11 == 2 && d1 == 2 && h1 == 0 && s == 0)
                h1 = 2;
            // reverse T / H scenario
            else if (a1 == 2 && c1 == 2 && h1 == 2 && e11 == 1 && b1 == 1 && d1 == 0 && s == 0)
                d1 = 2;
            else if (c1 == 2 && i1 == 2 && d1 == 2 && e11 == 1 && f1 == 1 &&  b1 == 0 && s == 0)
                b1 = 2;
            else if (b1 == 2 && g11 == 2 && i1 == 2 && e11 == 1 && h1 == 1 && f1 == 0 && s == 0)
                f1 = 2;
            else if (a1 == 2 && g11 == 2 && f1 == 2 && e11 == 1 && d1 == 1 && h1 == 0 && s == 0)
                h1 = 2;
            // one corner and a side
            else if (a1 == 1 && e11 == 2 && f1 == 1 && c1 == 0 && s == 0)
                c1 = 2;
            else if (a1 == 1 && e11 == 2 && h1 == 1 && g11 == 0 && s == 0)
                g1 = 2;
            else if (c1 == 1 && e11 == 2 && h1 == 1 && i1 == 0 && s == 0)
                i1 = 2;
            else if (c1 == 1 && e11 == 2 && d1 == 1 && a1 == 0 && s == 0)
                a1 = 2;
            else if (i1 == 1 && e11 == 2 && d1 == 1 && g11 == 0 && s == 0)
                g11 = 2;
            else if (i1 == 1 && e11 == 2 && b1 == 1 && c1 == 0 && s == 0)
                c1 = 2;
            else if (g11 == 1 && e11 == 2 && b1 == 1 && a1 == 0 && s == 0)
                a1 = 2;
            else if (g11 == 1 && e11 == 2 && f1 == 1 && i1 == 0 && s == 0)
                i1 = 2;

            //box t
            //diagonal line (no two in a row)
            else if (a2 == 2 && e2 == 1 && i2 == 1 && g2 == 0 && t == 0)
                g2 = 2;
            else if (c2 == 2 && e2 == 1 && g2 == 1 && a2 == 0 && t == 0)
                a2 = 2;
            else if (i2 == 2 && e2 == 1 && a2 == 1 && c2 == 0 && t == 0)
                c2 = 2;
            else if (g2 == 2 && e2 == 1 && c2 == 1 && i2 == 0 && t == 0)
                i2 = 2;
            else if (a2 == 1 && i2 == 1 && d2 == 0 && t == 0)
                d2 = 2;
            else if (c2 == 1 && g2 == 1 && f2 == 0 && t == 0)
                f2 = 2;
            // T scenario
            else if (a2 == 1 && c2 == 1 && h2 == 1 && e2 == 2 && b2 == 2 && d2 == 0 && t == 0)
                d2 = 2;
            else if (c2 == 1 && i2 == 1 && d2 == 1 && e2 == 2 && f2 == 2 &&  b2 == 0 && t == 0)
                b2 = 2;
            else if (b2 == 1 && g2 == 1 && i2 == 1 && e2 == 2 && h2 == 2 && f2 == 0 && t == 0)
                f2 = 2;
            else if (a2 == 1 && g2 == 1 && f2 == 1 && e2 == 2 && d2 == 2 && h2 == 0 && t == 0)
                h2 = 2;
            // reverse T / H scenario
            else if (a2 == 2 && c2 == 2 && h2 == 2 && e2 == 1 && b2 == 1 && d2 == 0 && t == 0)
                d2 = 2;
            else if (c2 == 2 && i2 == 2 && d2 == 2 && e2 == 1 && f2 == 1 &&  b2 == 0 && t == 0)
                b2 = 2;
            else if (b2 == 2 && g2 == 2 && i2 == 2 && e2 == 1 && h2 == 1 && f2 == 0 && t == 0)
                f2 = 2;
            else if (a2 == 2 && g2 == 2 && f2 == 2 && e2 == 1 && d2 == 1 && h2 == 0 && t == 0)
                h2 = 2;
            // one corner and a side
            else if (a2 == 1 && e2 == 2 && f2 == 1 && c2 == 0 && t == 0)
                c2 = 2;
            else if (a2 == 1 && e2 == 2 && h2 == 1 && g2 == 0 && t == 0)
                g2 = 2;
            else if (c2 == 1 && e2 == 2 && h2 == 1 && i2 == 0 && t == 0)
                i2 = 2;
            else if (c2 == 1 && e2 == 2 && d2 == 1 && a2 == 0 && t == 0)
                a2 = 2;
            else if (i2 == 1 && e2 == 2 && d2 == 1 && g2 == 0 && t == 0)
                g2 = 2;
            else if (i2 == 1 && e2 == 2 && b2 == 1 && c2 == 0 && t == 0)
                c2 = 2;
            else if (g2 == 1 && e2 == 2 && b2 == 1 && a2 == 0 && t == 0)
                a2 = 2;
            else if (g2 == 1 && e2 == 2 && f2 == 1 && i2 == 0 && t == 0)
                i2 = 2;

            //box u
            //diagonal line (no two in a row)
            else if (a3 == 2 && e3 == 1 && i3 == 1 && g3 == 0 && u == 0)
                g3 = 2;
            else if (c3 == 2 && e3 == 1 && g3 == 1 && a3 == 0 && u == 0)
                a3 = 2;
            else if (i3 == 2 && e3 == 1 && a3 == 1 && c3 == 0 && u == 0)
                c3 = 2;
            else if (g3 == 2 && e3 == 1 && c3 == 1 && i3 == 0 && u == 0)
                i3 = 2;
            else if (a3 == 1 && i3 == 1 && d3 == 0 && u == 0)
                d3 = 2;
            else if (c3 == 1 && g3 == 1 && f3 == 0 && u == 0)
                f3 = 2;
            // T scenario
            else if (a3 == 1 && c3 == 1 && h3 == 1 && e3 == 2 && b3 == 2 && d3 == 0 && u == 0)
                d3 = 2;
            else if (c3 == 1 && i3 == 1 && d3 == 1 && e3 == 2 && f3 == 2 && b3 == 0 && u == 0)
                b3 = 2;
            else if (b3 == 1 && g3 == 1 && i3 == 1 && e3 == 2 && h3 == 2 && f3 == 0 && u == 0)
                f3 = 2;
            else if (a3 == 1 && g3 == 1 && f3 == 1 && e3 == 2 && d3 == 2 && h3 == 0 && u == 0)
                h3 = 2;
            // reverse T / H scenario
            else if (a3 == 2 && c3 == 2 && h3 == 2 && e3 == 1 && b3 == 1 && d3 == 0 && u == 0)
                d3 = 2;
            else if (c3 == 2 && i3 == 2 && d3 == 2 && e3 == 1 && f3 == 1 && b3 == 0 && u == 0)
                b3 = 2;
            else if (b3 == 2 && g3 == 2 && i3 == 2 && e3 == 1 && h3 == 1 && f3 == 0 && u == 0)
                f3 = 2;
            else if (a3 == 2 && g3 == 2 && f3 == 2 && e3 == 1 && d3 == 1 && h3 == 0 && u == 0)
                h3 = 2;
            // one corner and a side
            else if (a3 == 1 && e3 == 2 && f3 == 1 && c3 == 0 && u == 0)
                c3 = 2;
            else if (a3 == 1 && e3 == 2 && h3 == 1 && g3 == 0 && u == 0)
                g3 = 2;
            else if (c3 == 1 && e3 == 2 && h3 == 1 && i3 == 0 && u == 0)
                i3 = 2;
            else if (c3 == 1 && e3 == 2 && d3 == 1 && a3 == 0 && u == 0)
                a3 = 2;
            else if (i3 == 1 && e3 == 2 && d3 == 1 && g3 == 0 && u == 0)
                g3 = 2;
            else if (i3 == 1 && e3 == 2 && b3 == 1 && c3 == 0 && u == 0)
                c3 = 2;
            else if (g3 == 1 && e3 == 2 && b3 == 1 && a3 == 0 && u == 0)
                a3 = 2;
            else if (g3 == 1 && e3 == 2 && f3 == 1 && i3 == 0 && u == 0)
                i3 = 2;

            //box v
            //diagonal line (no two in a row)
            else if (a4 == 2 && e4 == 1 && i4 == 1 && g4 == 0 && v == 0)
                g4 = 2;
            else if (c4 == 2 && e4 == 1 && g4 == 1 && a4 == 0 && v == 0)
                a4 = 2;
            else if (i4 == 2 && e4 == 1 && a4 == 1 && c4 == 0 && v == 0)
                c4 = 2;
            else if (g4 == 2 && e4 == 1 && c4 == 1 && i4 == 0 && v == 0)
                i4 = 2;
            else if (a4 == 1 && i4 == 1 && d4 == 0 && v == 0)
                d4 = 2;
            else if (c4 == 1 && g4 == 1 && f4 == 0 && v == 0)
                f4 = 2;
            // T scenario
            else if (a4 == 1 && c4 == 1 && h4 == 1 && e4 == 2 && b4 == 2 && d4 == 0 && v == 0)
                d4 = 2;
            else if (c4 == 1 && i4 == 1 && d4 == 1 && e4 == 2 && f4 == 2 && b4 == 0 && v == 0)
                b4 = 2;
            else if (b4 == 1 && g4 == 1 && i4 == 1 && e4 == 2 && h4 == 2 && f4 == 0 && v == 0)
                f4 = 2;
            else if (a4 == 1 && g4 == 1 && f4 == 1 && e4 == 2 && d4 == 2 && h4 == 0 && v == 0)
                h4 = 2;
            // reverse T / H scenario
            else if (a4 == 2 && c4 == 2 && h4 == 2 && e4 == 1 && b4 == 1 && d4 == 0 && v == 0)
                d4 = 2;
            else if (c4 == 2 && i4 == 2 && d4 == 2 && e4 == 1 && f4 == 1 && b4 == 0 && v == 0)
                b4 = 2;
            else if (b4 == 2 && g4 == 2 && i4 == 2 && e4 == 1 && h4 == 1 && f4 == 0 && v == 0)
                f4 = 2;
            else if (a4 == 2 && g4 == 2 && f4 == 2 && e4 == 1 && d4 == 1 && h4 == 0 && v == 0)
                h4 = 2;
            // one corner and a side
            else if (a4 == 1 && e4 == 2 && f4 == 1 && c4 == 0 && v == 0)
                c4 = 2;
            else if (a4 == 1 && e4 == 2 && h4 == 1 && g4 == 0 && v == 0)
                g4 = 2;
            else if (c4 == 1 && e4 == 2 && h4 == 1 && i4 == 0 && v == 0)
                i4 = 2;
            else if (c4 == 1 && e4 == 2 && d4 == 1 && a4 == 0 && v == 0)
                a4 = 2;
            else if (i4 == 1 && e4 == 2 && d4 == 1 && g4 == 0 && v == 0)
                g4 = 2;
            else if (i4 == 1 && e4 == 2 && b4 == 1 && c4 == 0 && v == 0)
                c4 = 2;
            else if (g4 == 1 && e4 == 2 && b4 == 1 && a4 == 0 && v == 0)
                a4 = 2;
            else if (g4 == 1 && e4 == 2 && f4 == 1 && i4 == 0 && v == 0)
                i4 = 2;

            //box w
            //diagonal line (no two in a row)
            else if (a5 == 2 && e5 == 1 && i5 == 1 && g5 == 0 && w == 0)
                g5 = 2;
            else if (c5 == 2 && e5 == 1 && g5 == 1 && a5 == 0 && w == 0)
                a5 = 2;
            else if (i5 == 2 && e5 == 1 && a5 == 1 && c5 == 0 && w == 0)
                c5 = 2;
            else if (g5 == 2 && e5 == 1 && c5 == 1 && i5 == 0 && w == 0)
                i5 = 2;
            else if (a5 == 1 && i5 == 1 && d5 == 0 && w == 0)
                d5 = 2;
            else if (c5 == 1 && g5 == 1 && f5 == 0 && w == 0)
                f5 = 2;
            // T scenario
            else if (a5 == 1 && c5 == 1 && h5 == 1 && e5 == 2 && b5 == 2 && d5 == 0 && w == 0)
                d5 = 2;
            else if (c5 == 1 && i5 == 1 && d5 == 1 && e5 == 2 && f5 == 2 && b5 == 0 && w == 0)
                b5 = 2;
            else if (b5 == 1 && g5 == 1 && i5 == 1 && e5 == 2 && h5 == 2 && f5 == 0 && w == 0)
                f5 = 2;
            else if (a5 == 1 && g5 == 1 && f5 == 1 && e5 == 2 && d5 == 2 && h5 == 0 && w == 0)
                h5 = 2;
            // reverse T / H scenario
            else if (a5 == 2 && c5 == 2 && h5 == 2 && e5 == 1 && b5 == 1 && d5 == 0 && w == 0)
                d5 = 2;
            else if (c5 == 2 && i5 == 2 && d5 == 2 && e5 == 1 && f5 == 1 && b5 == 0 && w == 0)
                b5 = 2;
            else if (b5 == 2 && g5 == 2 && i5 == 2 && e5 == 1 && h5 == 1 && f5 == 0 && w == 0)
                f5 = 2;
            else if (a5 == 2 && g5 == 2 && f5 == 2 && e5 == 1 && d5 == 1 && h5 == 0 && w == 0)
                h5 = 2;
            // one corner and a side
            else if (a5 == 1 && e5 == 2 && f5 == 1 && c5 == 0 && w == 0)
                c5 = 2;
            else if (a5 == 1 && e5 == 2 && h5 == 1 && g5 == 0 && w == 0)
                g5 = 2;
            else if (c5 == 1 && e5 == 2 && h5 == 1 && i5 == 0 && w == 0)
                i5 = 2;
            else if (c5 == 1 && e5 == 2 && d5 == 1 && a5 == 0 && w == 0)
                a5 = 2;
            else if (i5 == 1 && e5 == 2 && d5 == 1 && g5 == 0 && w == 0)
                g5 = 2;
            else if (i5 == 1 && e5 == 2 && b5 == 1 && c5 == 0 && w == 0)
                c5 = 2;
            else if (g5 == 1 && e5 == 2 && b5 == 1 && a5 == 0 && w == 0)
                a5 = 2;
            else if (g5 == 1 && e5 == 2 && f5 == 1 && i5 == 0 && w == 0)
                i5 = 2;

            //box x1
            //diagonal line (no two in a row)
            else if (a6 == 2 && e6 == 1 && i6 == 1 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (c6 == 2 && e6 == 1 && g6 == 1 && a6 == 0 && x1 == 0)
                a6 = 2;
            else if (i6 == 2 && e6 == 1 && a6 == 1 && c6 == 0 && x1 == 0)
                c6 = 2;
            else if (g6 == 2 && e6 == 1 && c6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (a6 == 1 && i6 == 1 && d6 == 0 && x1 == 0)
                d6 = 2;
            else if (c6 == 1 && g6 == 1 && f6 == 0 && x1 == 0)
                f6 = 2;
            // T scenario
            else if (a6 == 1 && c6 == 1 && h6 == 1 && e6 == 2 && b6 == 2 && d6 == 0 && x1 == 0)
                d6 = 2;
            else if (c6 == 1 && i6 == 1 && d6 == 1 && e6 == 2 && f6 == 2 && b6 == 0 && x1 == 0)
                b6 = 2;
            else if (b6 == 1 && g6 == 1 && i6 == 1 && e6 == 2 && h6 == 2 && f6 == 0 && x1 == 0)
                f6 = 2;
            else if (a6 == 1 && g6 == 1 && f6 == 1 && e6 == 2 && d6 == 2 && h6 == 0 && x1 == 0)
                h6 = 2;
            // reverse T / H scenario
            else if (a6 == 2 && c6 == 2 && h6 == 2 && e6 == 1 && b6 == 1 && d6 == 0 && x1 == 0)
                d6 = 2;
            else if (c6 == 2 && i6 == 2 && d6 == 2 && e6 == 1 && f6 == 1 && b6 == 0 && x1 == 0)
                b6 = 2;
            else if (b6 == 2 && g6 == 2 && i6 == 2 && e6 == 1 && h6 == 1 && f6 == 0 && x1 == 0)
                f6 = 2;
            else if (a6 == 2 && g6 == 2 && f6 == 2 && e6 == 1 && d6 == 1 && h6 == 0 && x1 == 0)
                h6 = 2;
            // one corner and a side
            else if (a6 == 1 && e6 == 2 && f6 == 1 && c6 == 0 && x1 == 0)
                c6 = 2;
            else if (a6 == 1 && e6 == 2 && h6 == 1 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (c6 == 1 && e6 == 2 && h6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;
            else if (c6 == 1 && e6 == 2 && d6 == 1 && a6 == 0 && x1 == 0)
                a6 = 2;
            else if (i6 == 1 && e6 == 2 && d6 == 1 && g6 == 0 && x1 == 0)
                g6 = 2;
            else if (i6 == 1 && e6 == 2 && b6 == 1 && c6 == 0 && x1 == 0)
                c6 = 2;
            else if (g6 == 1 && e6 == 2 && b6 == 1 && a6 == 0 && x1 == 0)
                a6 = 2;
            else if (g6 == 1 && e6 == 2 && f6 == 1 && i6 == 0 && x1 == 0)
                i6 = 2;

            //box y1
            //diagonal line (no two in a row)
            else if (a7 == 2 && e7 == 1 && i7 == 1 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (c7 == 2 && e7 == 1 && g7 == 1 && a7 == 0 && y1 == 0)
                a7 = 2;
            else if (i7 == 2 && e7 == 1 && a7 == 1 && c7 == 0 && y1 == 0)
                c7 = 2;
            else if (g7 == 2 && e7 == 1 && c7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (a7 == 1 && i7 == 1 && d7 == 0 && y1 == 0)
                d7 = 2;
            else if (c7 == 1 && g7 == 1 && f7 == 0 && y1 == 0)
                f7 = 2;
            // T scenario
            else if (a7 == 1 && c7 == 1 && h7 == 1 && e7 == 2 && b7 == 2 && d7 == 0 && y1 == 0)
                d7 = 2;
            else if (c7 == 1 && i7 == 1 && d7 == 1 && e7 == 2 && f7 == 2 && b7 == 0 && y1 == 0)
                b7 = 2;
            else if (b7 == 1 && g7 == 1 && i7 == 1 && e7 == 2 && h7 == 2 && f7 == 0 && y1 == 0)
                f7 = 2;
            else if (a7 == 1 && g7 == 1 && f7 == 1 && e7 == 2 && d7 == 2 && h7 == 0 && y1 == 0)
                h7 = 2;
            // reverse T / H scenario
            else if (a7 == 2 && c7 == 2 && h7 == 2 && e7 == 1 && b7 == 1 && d7 == 0 && y1 == 0)
                d7 = 2;
            else if (c7 == 2 && i7 == 2 && d7 == 2 && e7 == 1 && f7 == 1 && b7 == 0 && y1 == 0)
                b7 = 2;
            else if (b7 == 2 && g7 == 2 && i7 == 2 && e7 == 1 && h7 == 1 && f7 == 0 && y1 == 0)
                f7 = 2;
            else if (a7 == 2 && g7 == 2 && f7 == 2 && e7 == 1 && d7 == 1 && h7 == 0 && y1 == 0)
                h7 = 2;
            // one corner and a side
            else if (a7 == 1 && e7 == 2 && f7 == 1 && c7 == 0 && y1 == 0)
                c7 = 2;
            else if (a7 == 1 && e7 == 2 && h7 == 1 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (c7 == 1 && e7 == 2 && h7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;
            else if (c7 == 1 && e7 == 2 && d7 == 1 && a7 == 0 && y1 == 0)
                a7 = 2;
            else if (i7 == 1 && e7 == 2 && d7 == 1 && g7 == 0 && y1 == 0)
                g7 = 2;
            else if (i7 == 1 && e7 == 2 && b7 == 1 && c7 == 0 && y1 == 0)
                c7 = 2;
            else if (g7 == 1 && e7 == 2 && b7 == 1 && a7 == 0 && y1 == 0)
                a7 = 2;
            else if (g7 == 1 && e7 == 2 && f7 == 1 && i7 == 0 && y1 == 0)
                i7 = 2;

            //box z
            //diagonal line (no two in a row)
            else if (a8 == 2 && e8 == 1 && i8 == 1 && g8 == 0 && z == 0)
                g8 = 2;
            else if (c8 == 2 && e8 == 1 && g8 == 1 && a8 == 0 && z == 0)
                a8 = 2;
            else if (i8 == 2 && e8 == 1 && a8 == 1 && c8 == 0 && z == 0)
                c8 = 2;
            else if (g8 == 2 && e8 == 1 && c8 == 1 && i8 == 0 && z == 0)
                i8 = 2;
            else if (a8 == 1 && i8 == 1 && d8 == 0 && z == 0)
                d8 = 2;
            else if (c8 == 1 && g8 == 1 && f8 == 0 && z == 0)
                f8 = 2;
            // T scenario
            else if (a8 == 1 && c8 == 1 && h8 == 1 && e8 == 2 && b8 == 2 && d8 == 0 && z == 0)
                d8 = 2;
            else if (c8 == 1 && i8 == 1 && d8 == 1 && e8 == 2 && f8 == 2 && b8 == 0 && z == 0)
                b8 = 2;
            else if (b8 == 1 && g8 == 1 && i8 == 1 && e8 == 2 && h8 == 2 && f8 == 0 && z == 0)
                f8 = 2;
            else if (a8 == 1 && g8 == 1 && f8 == 1 && e8 == 2 && d8 == 2 && h8 == 0 && z == 0)
                h8 = 2;
            // reverse T / H scenario
            else if (a8 == 2 && c8 == 2 && h8 == 2 && e8 == 1 && b8 == 1 && d8 == 0 && z == 0)
                d8 = 2;
            else if (c8 == 2 && i8 == 2 && d8 == 2 && e8 == 1 && f8 == 1 && b8 == 0 && z == 0)
                b8 = 2;
            else if (b8 == 2 && g8 == 2 && i8 == 2 && e8 == 1 && h8 == 1 && f8 == 0 && z == 0)
                f8 = 2;
            else if (a8 == 2 && g8 == 2 && f8 == 2 && e8 == 1 && d8 == 1 && h8 == 0 && z == 0)
                h8 = 2;
            // one corner and a side
            else if (a8 == 1 && e8 == 2 && f8 == 1 && c8 == 0 && z == 0)
                c8 = 2;
            else if (a8 == 1 && e8 == 2 && h8 == 1 && g8 == 0 && z == 0)
                g8 = 2;
            else if (c8 == 1 && e8 == 2 && h8 == 1 && i8 == 0 && z == 0)
                i8 = 2;
            else if (c8 == 1 && e8 == 2 && d8 == 1 && a8 == 0 && z == 0)
                a8 = 2;
            else if (i8 == 1 && e8 == 2 && d8 == 1 && g8 == 0 && z == 0)
                g8 = 2;
            else if (i8 == 1 && e8 == 2 && b8 == 1 && c8 == 0 && z == 0)
                c8 = 2;
            else if (g8 == 1 && e8 == 2 && b8 == 1 && a8 == 0 && z == 0)
                a8 = 2;
            else if (g8 == 1 && e8 == 2 && f8 == 1 && i8 == 0 && z == 0)
                i8 = 2;

            // fixes the straight line problem
            else if (a == 0 && c == 0 && g1 == 0 && i == 0 && r == 0) // picks a random corner for move 1
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a = 2;
                else if (corner == 2)
                    c = 2;
                else if (corner == 3)
                    g1 = 2;
                else if (corner == 4)
                    i = 2;
            }
            else if (a1 == 0 && c1 == 0 && g11 == 0 && i1 == 0 && s == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a1 = 2;
                else if (corner == 2)
                    c1 = 2;
                else if (corner == 3)
                    g11 = 2;
                else if (corner == 4)
                    i1 = 2;
            }
            else if (a2 == 0 && c2 == 0 && g2 == 0 && i2 == 0 && t == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a2 = 2;
                else if (corner == 2)
                    c2 = 2;
                else if (corner == 3)
                    g2 = 2;
                else if (corner == 4)
                    i2 = 2;
            }
            else if (a3 == 0 && c3 == 0 && g3 == 0 && i3 == 0 && u == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a3 = 2;
                else if (corner == 2)
                    c3 = 2;
                else if (corner == 3)
                    g3 = 2;
                else if (corner == 4)
                    i3 = 2;
            }
            else if (a4 == 0 && c4 == 0 && g4 == 0 && i4 == 0 && v == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a4 = 2;
                else if (corner == 2)
                    c4 = 2;
                else if (corner == 3)
                    g4 = 2;
                else if (corner == 4)
                    i4 = 2;
            }
            else if (a5 == 0 && c5 == 0 && g5 == 0 && i5 == 0 && w == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a5 = 2;
                else if (corner == 2)
                    c5 = 2;
                else if (corner == 3)
                    g5 = 2;
                else if (corner == 4)
                    i5 = 2;
            }
            else if (a6 == 0 && c6 == 0 && g6 == 0 && i6 == 0 && x1 == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a6 = 2;
                else if (corner == 2)
                    c6 = 2;
                else if (corner == 3)
                    g6 = 2;
                else if (corner == 4)
                    i6 = 2;
            }
            else if (a7 == 0 && c7 == 0 && g7 == 0 && i7 == 0 && y1 == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a7 = 2;
                else if (corner == 2)
                    c7 = 2;
                else if (corner == 3)
                    g7 = 2;
                else if (corner == 4)
                    i7 = 2;
            }
            else if (a8 == 0 && c8 == 0 && g8 == 0 && i8 == 0 && z == 0)
            {
                corner = (int)(4 * Math.random() + 1);
                if (corner == 1)
                    a8 = 2;
                else if (corner == 2)
                    c8 = 2;
                else if (corner == 3)
                    g8 = 2;
                else if (corner == 4)
                    i8 = 2;
            }
            //if middle and a corner is taken in all boxes
            else if (d == 0 && r == 0)
                d = 2;
            else if (d1 == 0 && s == 0)
                d1 = 2;
            else if (d2 == 0 && t == 0)
                d2 = 2;
            else if (d3 == 0 && u == 0)
                d3 = 2;
            else if (d4 == 0 && v == 0)
                d4 = 2;
            else if (d5 == 0 && w == 0)
                d5 = 2;
            else if (d6 == 0 && x1 == 0)
                d6 = 2;
            else if (d7 == 0 && y1 == 0)
                d7 = 2;
            else if (d8 == 0 && z == 0)
                d8 = 2;
                
            // last move - if nothing else works
            // box r
            else if (a == 0 && r == 0)
                a = 2;
            else if (b == 0 && r == 0)
                b = 2;
            else if (c == 0 && r == 0)
                c = 2;
            else if (d == 0 && r == 0)
                d = 2;
            else if (e1 == 0 && r == 0)
                e1 = 2;
            else if (f == 0 && r == 0)
                f = 2;
            else if (g1 == 0 && r == 0)
                g1 = 2;
            else if (h == 0 && r == 0)
                h = 2;
            else if (i == 0 && r == 0)
                i = 2;
            // box s
            else if (a1 == 0 && s == 0)
                a1 = 2;
            else if (b1 == 0 && s == 0)
                b1 = 2;
            else if (c1 == 0 && s == 0)
                c1 = 2;
            else if (d1 == 0 && s == 0)
                d1 = 2;
            else if (e11 == 0 && s == 0)
                e11 = 2;
            else if (f1 == 0 && s == 0)
                f1 = 2;
            else if (g11 == 0 && s == 0)
                g11 = 2;
            else if (h1 == 0 && s == 0)
                h1 = 2;
            else if (i1 == 0 && s == 0)
                i1 = 2;
            // box t
            else if (a2 == 0 && t == 0)
                a2 = 2;
            else if (b2 == 0 && t == 0)
                b2 = 2;
            else if (c2 == 0 && t == 0)
                c2 = 2;
            else if (d2 == 0 && t == 0)
                d2 = 2;
            else if (e2 == 0 && t == 0)
                e2 = 2;
            else if (f2 == 0 && t == 0)
                f2 = 2;
            else if (g2 == 0 && t == 0)
                g2 = 2;
            else if (h2 == 0 && t == 0)
                h2 = 2;
            else if (i2 == 0 && t == 0)
                i2 = 2;
            // box u
            else if (a3 == 0 && u == 0)
                a3 = 2;
            else if (b3 == 0 && u == 0)
                b3 = 2;
            else if (c3 == 0 && u == 0)
                c3 = 2;
            else if (d3 == 0 && u == 0)
                d3 = 2;
            else if (e3 == 0 && u == 0)
                e3 = 2;
            else if (f3 == 0 && u == 0)
                f3 = 2;
            else if (g3 == 0 && u == 0)
                g3 = 2;
            else if (h3 == 0 && u == 0)
                h3 = 2;
            else if (i3 == 0 && u == 0)
                i3 = 2;
            // box v
            else if (a4 == 0 && v == 0)
                a4 = 2;
            else if (b4 == 0 && v == 0)
                b4 = 2;
            else if (c4 == 0 && v == 0)
                c4 = 2;
            else if (d4 == 0 && v == 0)
                d4 = 2;
            else if (e4 == 0 && v == 0)
                e4 = 2;
            else if (f4 == 0 && v == 0)
                f4 = 2;
            else if (g4 == 0 && v == 0)
                g4 = 2;
            else if (h4 == 0 && v == 0)
                h4 = 2;
            else if (i4 == 0 && v == 0)
                i4 = 2;
            // box w
            else if (a5 == 0 && w == 0)
                a5 = 2;
            else if (b5 == 0 && w == 0)
                b5 = 2;
            else if (c5 == 0 && w == 0)
                c5 = 2;
            else if (d5 == 0 && w == 0)
                d5 = 2;
            else if (e5 == 0 && w == 0)
                e5 = 2;
            else if (f5 == 0 && w == 0)
                f5 = 2;
            else if (g5 == 0 && w == 0)
                g5 = 2;
            else if (h5 == 0 && w == 0)
                h5 = 2;
            else if (i5 == 0 && w == 0)
                i5 = 2;
            // box x1
            else if (a6 == 0 && x1 == 0)
                a6 = 2;
            else if (b6 == 0 && x1 == 0)
                b6 = 2;
            else if (c6 == 0 && x1 == 0)
                c6 = 2;
            else if (d6 == 0 && x1 == 0)
                d6 = 2;
            else if (e6 == 0 && x1 == 0)
                e6 = 2;
            else if (f6 == 0 && x1 == 0)
                f6 = 2;
            else if (g6 == 0 && x1 == 0)
                g6 = 2;
            else if (h6 == 0 && x1 == 0)
                h6 = 2;
            else if (i6 == 0 && x1 == 0)
                i6 = 2;
            // box y1
            else if (a7 == 0 && y1 == 0)
                a7 = 2;
            else if (b7 == 0 && y1 == 0)
                b7 = 2;
            else if (c7 == 0 && y1 == 0)
                c7 = 2;
            else if (d7 == 0 && y1 == 0)
                d7 = 2;
            else if (e7 == 0 && y1 == 0)
                e7 = 2;
            else if (f7 == 0 && y1 == 0)
                f7 = 2;
            else if (g7 == 0 && y1 == 0)
                g7 = 2;
            else if (h7 == 0 && y1 == 0)
                h7 = 2;
            else if (i7 == 0 && y1 == 0)
                i7 = 2;
            // box z
            else if (a8 == 0 && z == 0)
                a8 = 2;
            else if (b8 == 0 && z == 0)
                b8 = 2;
            else if (c8 == 0 && z == 0)
                c8 = 2;
            else if (d8 == 0 && z == 0)
                d8 = 2;
            else if (e8 == 0 && z == 0)
                e8 = 2;
            else if (f8 == 0 && z == 0)
                f8 = 2;
            else if (g8 == 0 && z == 0)
                g8 = 2;
            else if (h8 == 0 && z == 0)
                h8 = 2;
            else if (i8 == 0 && z == 0)
                i8 = 2;
        }

        turn = 1;
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }
}