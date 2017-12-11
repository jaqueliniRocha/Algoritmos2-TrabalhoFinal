package model;

public class Celula<T> {
	
	private T elemento;
    private Celula<T> proxima;
    private Celula<T> anterior;
    
    public Celula(){
    	
    }
    
    public Celula(T elemento, Celula<T> proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public Celula<T> getProxima() {
        return proxima;
    }

    public void setProxima(Celula<T> proxima) {
        this.proxima = proxima;
    }

    public T getElemento() {
        return elemento;
    }

	public Celula<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula<T> anterior) {
		this.anterior = anterior;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
}
