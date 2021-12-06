import jade.core.AID
import jade.core.behaviours.SimpleBehaviour
import jade.lang.acl.ACLMessage

fun mapToString(hMap: HashMap<AID, Int>): String {
    return hMap.map({ (aid, value) -> "${aid.name.split("@")[0]}: $value" }).toString()
}

class MTAgentBehaviour(
    private val agent: MTAgent,
    private var number: Double,
    private val nodesNum: Int,
    private val connectedAgents: List<AID>
) :
    SimpleBehaviour() {
    private var state: Int = 0
    private val alpha: Double = 1.0 / nodesNum.toDouble()
    private val name = agent.name.split("@")[0]

    override fun action() {
//      Send collected numbers to all neighbours
        for (connectedAgent in connectedAgents) {
            val msg = ACLMessage(ACLMessage.INFORM)
            msg.content = this.number.toString()
            msg.addReceiver(connectedAgent)
            agent.send(msg)
        }

//      Receive collected numbers from all neighbours
        var sum: Double = 0.0
        for (i in 1..connectedAgents.size) {
            val receivedMessage = agent.blockingReceive()
            sum += receivedMessage.content.toDouble()
        }
        number = (number + sum) * alpha
        state++

        if ((state == nodesNum * 2 - 1) and (name.toString() == "0"))
        println("$number")
    }

    override fun done(): Boolean {
        return state == nodesNum * 2;
    }

}
