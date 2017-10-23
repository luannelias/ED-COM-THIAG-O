package listase;
import java.awt.event.*;
import javax.swing.*;

public class InterfaceListaSE extends JFrame implements ActionListener
{ 
    MetodosListaSE lista = new MetodosListaSE();
    private int dado;
    private int posicao;
    
    //janela
    JButton Adicionar = new JButton("Adicionar");
    JButton BuscarE = new JButton("Buscar Elemento");
    JButton BuscarP = new JButton("Buscar Posição");
    JButton Remover = new JButton("Remover");
    JButton okAdd = new JButton("Ok");
    JButton okBusE = new JButton("Ok");
    JButton okBusP = new JButton("Ok");
    JButton okRem = new JButton("Ok");
    
    //caixa
    JTextField CaixaValor = new JTextField();
    JTextField CaixaPosicao = new JTextField ();
    
    //lengendas
    JLabel MsgValor = new JLabel("Valor:");
    JLabel MsgPosicao = new JLabel("Posição:");
    
    public InterfaceListaSE()
    {
        //comando de botões
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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        okAdd.addActionListener(this);
        okBusP.addActionListener(this);
        okBusE.addActionListener(this);
        okRem.addActionListener(this);
        
        if (ae.getSource()==Adicionar)
        {
            //criando legendas
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
            
            okAdd.setBounds(370, 52, 80, 20);
            add(okAdd);
        }
        
        if (ae.getSource()==BuscarE) //busca o elemento
        {
            remove(Adicionar);
            remove(BuscarP);
            remove(Remover);
            MsgPosicao.setBounds(189, 50, 120, 25);
            add(MsgPosicao);
            
            CaixaPosicao.setBounds(240, 50, 120, 25);
            add(CaixaPosicao);
            
            okBusE.setBounds(370, 51, 80, 20);
            add(okBusE);
        }
        
        if (ae.getSource()==BuscarP) //retorno o elemento da posição
        {
            remove(Adicionar);
            remove(BuscarE);
            remove(Remover);
            MsgValor.setBounds(205, 50, 120, 25);
            add(MsgValor);
            
            CaixaValor.setBounds(240, 50, 120, 25);
            add(CaixaValor);
            
            okBusP.setBounds(370, 51, 80, 20);
            add(okBusP);
        }
        
        if (ae.getSource()==Remover)
        {
            remove(Adicionar);
            remove(BuscarE);
            remove(BuscarP);
            MsgPosicao.setBounds(189, 50, 120, 25);
            add(MsgPosicao);
            
            CaixaPosicao.setBounds(240, 50, 120, 25);
            add(CaixaPosicao);
            
            okRem.setBounds(370, 51, 80, 20);
            add(okRem);
        }
        
        if (ae.getSource()==okAdd)
        {
            dado=Integer.parseInt(this.CaixaValor.getText());
            posicao=Integer.parseInt(this.CaixaPosicao.getText());
            lista.insere(posicao, dado);
        }
        
        if (ae.getSource()==okBusE)
        {
            posicao=Integer.parseInt(this.CaixaPosicao.getText());
            lista.elemento(posicao);
            
        }
        
        if (ae.getSource()==okBusP)
        {
            dado=Integer.parseInt(this.CaixaValor.getText());
            lista.posicao(dado);
        }
        
        if (ae.getSource()==okRem)
        {
            posicao=Integer.parseInt(this.CaixaPosicao.getText());
            lista.remove(posicao);
        }
        repaint();
    }
}
