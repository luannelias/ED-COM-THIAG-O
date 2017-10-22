package listase;
//import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;

public class InterfaceListaSE extends JFrame implements ActionListener
{ 
    //janela
    JButton Adicionar = new JButton("Adicionar");
    JButton BuscarE = new JButton("Buscar Elemento");
    JButton BuscarP = new JButton("Buscar Posição");
    JButton Remover = new JButton("Remover");
    JButton Ok = new JButton("Ok");
    
    //caixa
    JTextField CaixaValor = new JTextField();
    JTextField CaixaPosicao = new JTextField ();
    
    //mensagens
    JLabel MsgValor = new JLabel("Valor:");
    JLabel MsgPosicao = new JLabel("Posição:");
    
    public InterfaceListaSE()
    {
        Adicionar.addActionListener(this);
        BuscarE.addActionListener(this);
        BuscarP.addActionListener(this);
        Remover.addActionListener(this);
        
        
        //criando botões
        setLayout(null);
        Adicionar.setBounds(1, 1, 140, 30);
        add(Adicionar);
        BuscarE.setBounds(1, 29, 140, 30);
        add(BuscarE);
        BuscarP.setBounds(1, 58, 140, 30);
        add(BuscarP);
        Remover.setBounds(1, 87, 140, 30);
        add(Remover);

        //criando janela
        setTitle ("Lista Simplesmente Encadeada");
        setSize (500, 400);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);
      //setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Ok.addActionListener(this);
        
        if (e.getSource()==Adicionar)
        {
            //criando avisos
            remove(BuscarE);
            remove(BuscarP);
            remove(Remover);
            MsgValor.setBounds(205, 20, 120, 25);
            add(MsgValor);
            MsgPosicao.setBounds(189, 80, 120, 25);
            add(MsgPosicao);

            //criando caixa
            CaixaValor.setBounds(240, 20, 120, 25);
            add(CaixaValor);
            CaixaPosicao.setBounds(240, 80, 120, 25);
            add(CaixaPosicao);
            
            Ok.setBounds(370, 52, 80, 20);
            add(Ok);        
        }
        
        if (e.getSource()==BuscarE)
        {
            remove(Adicionar);
            remove(BuscarP);
            remove(Remover);
            MsgValor.setBounds(205, 50, 120, 25);
            add(MsgValor);
            
            CaixaValor.setBounds(240, 50, 120, 25);
            add(CaixaValor);
            
            Ok.setBounds(370, 51, 80, 20);
            add(Ok);
        }
        
        if (e.getSource()==BuscarP)
        {
            remove(Adicionar);
            remove(BuscarE);
            remove(Remover);
            MsgPosicao.setBounds(189, 50, 120, 25);
            add(MsgPosicao);
            
            CaixaPosicao.setBounds(240, 50, 120, 25);
            add(CaixaPosicao);
            
            Ok.setBounds(370, 51, 80, 20);
            add(Ok);
        }
        
        if (e.getSource()==Remover)
        {
            remove(Adicionar);
            remove(BuscarE);
            remove(BuscarP);
            MsgPosicao.setBounds(189, 50, 120, 25);
            add(MsgPosicao);
            
            CaixaPosicao.setBounds(240, 50, 120, 25);
            add(CaixaPosicao);
            
            Ok.setBounds(370, 51, 80, 20);
            add(Ok);
            
            if (e.getSource()==Ok)
            {
                System.out.println("Olá");
            }
        }
        
        int valor, posicao;
        if (e.getSource()==Ok)
        {
            valor=Integer.parseInt(this.CaixaValor.getText());
            posicao=Integer.parseInt(this.CaixaPosicao.getText());
        }
        repaint();
    }

}
