/* Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Kotlin
 * Recursos: Kotlin Playground
 * Historial: Finalizado el 16.07.2022 */

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    //println(result?.get(0))
    result?.forEach{
        println(it);
    }
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var returnList: MutableList<ItemData>? = mutableListOf<ItemData>(); //Lista de retorno
    
    if (inputList == null) { //Sí la lista es null 
        return null;
    }
    
    else { //Sí la lista NO es null 
        inputList?.forEach {
        var i = inputList.indexOf(it);
		
		//Análisis de los tipos
        when (it) {
                is Int -> {
                    var item = ItemInt(it, i);
                    returnList?.add(item);
                }
                is String -> {
                    var item = ItemString(it, i);
                    returnList?.add(item);
                }
                is Boolean -> {
                    var item = ItemBoolean(it, i);
                    returnList?.add(item);
                }
                else -> {
                    if (it != null){
                         var item = ItemOther(it, i);
                    	returnList?.add(item);
                    }
                }
            }
        }
        return returnList;
    }
}

//Funcion para crear un ItemData de un Int
fun ItemInt(element: Int, index: Int): ItemData {
    var type: String? = "entero";
    
    //Encontrar la info
    var info: String? = null
    if((element % 10) == 0) {
        info = "M10"
    }
    else if((element % 5) == 0) {
        info = "M5"
    }
    else if ((element % 2) == 0) {
        info = "M2"
    }
    else {
        info = null;
    }
    
    var item = ItemData(index, element, type, info);
    return item;
}

//Funcion para crear un ItemData de un String
fun ItemString(element: String, index: Int): ItemData {
    var type: String? = "cadena";
    
    //Encontrar la info
    var info: String? = null;
    var c: Int = 0;
    
    element.forEach {
        c++;
    }
    
    info = "L" + "" + c;
    
    var item = ItemData(index, element, type, info);
    return item;
}

//Funcion para crear un ItemData de un Boolean
fun ItemBoolean(element: Boolean, index: Int): ItemData {
    var type: String? = "booleano";
    
    //Encontrar la info
    var info: String? = null;
    if (element == true){
        info = "Verdadero"
    }
    else {
        info = "Falso"
    }
    
    var item = ItemData(index, element, type, info);
    return item;
}

//Funcion para crear un ItemData de otro tipo (null)
fun ItemOther(element: Any, index: Int): ItemData {
    var type: String? = null;
    
    //Encontrar la info
    var info: String? = null;
    
    var item = ItemData(index, element, type, info);
    return item;
}
