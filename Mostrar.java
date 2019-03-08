public class Coleccion{
	import java.util.Map;
	private Map <String, Carta> global;
	private Map <String, Carta> local;

	public String generateId(Carta carta){
		int id = 0;
		if (carta.getTipo().equals("Trampa")){
			id = 1;
		}
		else if(carta.getTipo().equals("Hechizo")){
			id = 2;
		}
		else if(carta.getTipo().equals("Monstruo")){
			id = 3;
		}
		return(id+carta.getNombre());
	}
	
	public int Size(){
		return global.size();
	}

	public String mostrar(boolean useglobal, boolean ordenar){
		String retorno = "";
		ArrayList<Carta> actualCollection = new ArrayList<Carta>();
		if (useglobal){
			Iterator it = global.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				actualCollection.add(global.get(key));
			}
		}
		else{
			Iterator it = local.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				actualCollection.add(local.get(key));
			}
		}
		for(int i=0;i<actualCollection.size();i++){
			if (actualCollection.get(i).getTipo().equals("Trampa")){
				retorno = retorno + ("\nTipo: " + actualCollection.get(i).getTipo() + " Nombre: " + actualCollection.get(i).getNombre());
			}
		}
		for(int j=0;j<actualCollection.size();j++){
			if (actualCollection.get(j).getTipo().equals("Hechizo")){
				retorno = retorno + ("\nTipo: " + actualCollection.get(j).getTipo() + " Nombre: " + actualCollection.get(j).getNombre());
			}
		}for(int k=0;k<actualCollection.size();k++){
			if (actualCollection.get(k).getTipo().equals("Monstruo")){
				retorno = retorno + ("\nTipo: " + actualCollection.get(k).getTipo() + " Nombre: " + actualCollection.get(k).getNombre());
			}
		}
		return retorno;
	}

}