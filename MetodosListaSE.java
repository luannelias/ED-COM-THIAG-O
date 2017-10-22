package listase;
import listas.No;

public class MetodosListaSE 
{
    private No cabeca;
    private int nElementos;

    public MetodosListaSE()
    {
	cabeca = null;
	nElementos = 0;
    }
	
    public boolean vazia() 
    {
	if (nElementos == 0)
	    return true;
	    
        else
	    return false;
    }

    public int tamanho() 
    {
	//return nElementos;
        No aux = cabeca;
        int cont = 0;
        while(aux != null)
        {
            aux = aux.getProx();
            cont++;
        }
            
        return cont;
    }

    public int elemento (int pos) 
    {
	if (vazia()) 
        {
	    return -1; // Consulta falhou 
	}

	if ((pos < 1) || (pos > tamanho()))
        {
            return -1; // Posicao invalida 
	}
	    
	No aux = cabeca;
        // Percorre a lista do 1o elemento atÃ© pos 
	for (int i =1; i < pos; i++)
        {
            // modifica "aux" para apontar para o proximo elemento da lista 
            aux = aux.getProx();
	}

	return aux.getConteudo();
    }


    public int posicao (int dado) 
    {
        int cont = 1;
        No aux;

        /* Lista vazia */
        if (vazia()) 
        {
            return -1;
        }

        /* Percorre a lista do inicio ao fim atÃ© encontrar o elemento*/
        aux = cabeca;
        while (aux != null) 
        {
            /* Se encontrar o elemento, retorna sua posicao n;*/
            if (aux.getConteudo() == dado)
            {
                return cont;
            }

            /* modifica "aux" para apontar para o proximo elemento da lista */
            aux = aux.getProx();
            cont++;
        }

	return -1;
    }

    /** Insere nÃ³ em lista vazia */
    private boolean insereInicioLista(int valor) 
    {
        // Aloca memoria para novo no 
	No novoNo = new No();
	    
	// Insere novo elemento na cabeca da lista
	novoNo.setConteudo(valor);
	    
	novoNo.setProx(cabeca);
	cabeca = novoNo;
	nElementos++;
	return true;
    }

    /** Insere nÃ³ no meio da lista */
    private boolean insereMeioLista(int pos, int dado)
    {
	// Aloca memoria para novo no
	No novoNo = new No();
	novoNo.setConteudo(dado);

	// Localiza a pos. ANTERIOR onde serÃ¡ inserido o novo nÃ³
	No aux = cabeca;
	for (int i =1; i < pos-1; i++)
        {
            // modifica "aux" para apontar para o proximo elemento da lista 
            aux = aux.getProx();
	}
	
        /*while ((cont < pos-1) && (aux != null))
        {
	    aux = aux.getProx();
	    cont++;
	}

	if (aux == null) 
        {  
            // pos. invÃ¡lida 
	    return false;
	}*/

	// Insere novo elemento apos aux
	/*novoNo.setProx(aux.getProx());
	aux.setProx(novoNo);*/
	    
	// Insere novo elemento apos aux
	No p = aux.getProx();
	novoNo.setProx(p);
	aux.setProx(novoNo);
	    
	nElementos++;
	return true;
    }

    /** Insere nÃ³ no fim da lista */
    private boolean insereFimLista(int dado)
    {
	// Aloca memoria para novo no 
        No novoNo = new No();
	novoNo.setConteudo(dado);

	// Procura o final da lista 
        No aux = this.cabeca;
        while(aux.getProx() != null)
        {
            aux = aux.getProx();
	}

	novoNo.setProx(null);
        aux.setProx(novoNo);

        this.nElementos++;
        return true;
    }

    public boolean insere(int pos, int dado) 
    {
        if ((vazia()) && (pos != 1))
        {
	    return false; /* lista vazia mas posicao inv*/
	}

	/* inserÃ§Ã£o no inÃ­cio da lista (ou lista vazia)*/
	if (pos == 1)
        {
	    return insereInicioLista(dado);
	}
	
        /* inserÃ§Ã£o no fim da lista */
	else if (pos == nElementos+1)
        {
	    return insereFimLista(dado);
	}
	
        /* inserÃ§Ã£o no meio da lista */
	else
        {
	    return insereMeioLista(pos, dado);
	}
    }

    /** Remove elemento do inÃ­cio da lista */
    private int removeInicio()
    {
	No p = cabeca;

	// Dado recebe o dado removido
	int dado = p.getConteudo();

	// Retira o 1o elemento da lista (p)
	cabeca = p.getProx();
	nElementos--;

	// Sugere ao garbage collector que libere a memoria
	//  da regiao apontada por p
	p = null;

	return dado;
    }

    /** Remove elemento no meio da lista */
    private int removeMeio(int pos)
    {
	No atual = null, antecessor = null;
	int dado = -1;
	int cont = 1;

        /* Localiza o nÃ³ que serÃ¡ removido*/
        atual = cabeca;
        while((cont < pos) && (atual != null))
        {
            antecessor = atual;
	    atual = atual.getProx();
            cont++;
	}

	if (atual == null) 
        { 
            /* pos. invÃ¡lida */
            return -1;
	}

	/* retira o elemento da lista */
	dado = atual.getConteudo();
	antecessor.setProx(atual.getProx());
	nElementos--;

	atual = null;
	return dado;
    }
        
    public int remove(int pos) 
    {
        // Lista vazia 
	if (vazia()) 
        {
            return -1;
        }

	// RemoÃ§Ã£o do elemento da cabeÃ§a da lista 
	if (pos == 1)
        {
	    return removeInicio();
	}
	    
        // RemoÃ§Ã£o em outro lugar da lista
        else
        {
	    return removeMeio(pos);
	}
    }
}
