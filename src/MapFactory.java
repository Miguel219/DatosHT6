import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Silvio Orozco 18282
 * Jose Castaneda 18161
 */
class MapFactory<K,V> {

	public Map<K,V> getList(int tipo) {
    // seleccion de la implementacion a utilizar:
	   if(tipo==1) {
			return new HashMap<K,V>();
		}else if(tipo==2) {
			return new TreeMap<K,V>();
		}else {
			return new LinkedHashMap<K,V>();
		}
   }

}
