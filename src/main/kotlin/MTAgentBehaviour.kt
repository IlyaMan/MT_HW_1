import jade.core.AID
import jade.core.behaviours.SimpleBehaviour
import jade.lang.acl.ACLMessage
import kotlin.collections.HashMap

fun mapToString(hMap: HashMap<AID, Int>): String {
    return hMap.map({ (aid, value) -> "${aid.name.split("@")[0]}: $value" }).toString()
}

class MTAgentBehaviour(
    private val agent: MTAgent,
    private val initialNumber: Int,
    private val connectedAgents: List<AID>
) :
    SimpleBehaviour() {
    var state: Int = 0
    private val name = agent.name.split("@")[0]
    private val initialNumbers = hashMapOf<AID, Int>(AID(name, false) to initialNumber)
    override fun action() {
        println(initialNumbers)

        if (state == 2) { // When received no updates two times in a row calculate average
            val isFirst = initialNumbers.keys.all { it.name.split("@")[0] >= name }
            // Check if we are the first agent and print average only if we are
            if (isFirst) {
                val sum = initialNumbers.map { (_, value) -> value }.reduce { acc, value -> acc + value }
                println("Average: ${sum.toFloat() / initialNumbers.size.toFloat()}")
            }
//          Stop execution
            state++
        }
//      Send collected numbers to all neighbours
        for (connectedAgent in connectedAgents) {
            val msg = ACLMessage(ACLMessage.INFORM)
            msg.content = mapToString(initialNumbers)
            msg.addReceiver(connectedAgent)
            agent.send(msg)
        }
//      Receive collected numbers from all neighbours
        if (state < 2) {
            var arrayChangedFlag = false
            for (i in 1..connectedAgents.size) {
                val receivedMessage = agent.blockingReceive()
                receivedMessage.content.toString().replace("[", "").replace("]", "").split(", ").map {
                    val (ag, value) = it.split(": ")
                    val agName = AID(ag, false)
                    if (!initialNumbers.containsKey(agName)) {
                        initialNumbers[agName] = value.toInt()
                        arrayChangedFlag = true
                    }
                }
            }
            if (!arrayChangedFlag) state++
        }

    }

    override fun done(): Boolean {
        return state == 3;
    }

}
