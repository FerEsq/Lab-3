/* Programador: Fernanda Esquivel (esq21542@uvg.edu.gt).
 * Lenguaje: Kotlin
 * Recursos: Kotlin Playground
 * Historial: Finalizado el 24.07.2022 */

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
    result?.forEach{ println(it) }
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var returnList: MutableList<ItemData>? = mutableListOf<ItemData>(); //Lista de retorno
    if (inputList == null) { return null }
    else { inputList.forEach { 
        	when (it) { is Int -> { val item = ItemInt(it, inputList.indexOf(it)); returnList?.add(item) }
                		is String -> { val item = ItemString(it, inputList.indexOf(it)); returnList?.add(item) }
                		is Boolean -> { val item = ItemBoolean(it, inputList.indexOf(it)); returnList?.add(item) }
                		else -> { if (it != null){ val item = ItemOther(it, inputList.indexOf(it)); returnList?.add(item) } } } }
	return returnList }       
}

//Funcion para crear un ItemData de un Int
fun ItemInt(element: Int, index: Int): ItemData {  
    if(element % 10 == 0) return ItemData(index, element, "entero", "M10") else if(element % 5 == 0) return ItemData(index, element, "entero", "M5") else if (element % 2 == 0) return ItemData(index, element, "entero", "M2") else return ItemData(index, element, "entero", null)
    
}

//Funcion para crear un ItemData de un String
fun ItemString(element: String, index: Int): ItemData { 
    var c = 0
    element.forEach { c++ } 
    return ItemData(index, element, "cadena", "L" + "" + c);
}

//Funcion para crear un ItemData de un Boolean
fun ItemBoolean(element: Boolean, index: Int): ItemData {
    if (element) return ItemData(index, element, "booleano", "Verdadero") else return ItemData(index, element, "booleano", "Falso")
}

//Funcion para crear un ItemData de otro tipo (null)
fun ItemOther(element: Any, index: Int): ItemData {
    return ItemData(index, element, null, null)
}
