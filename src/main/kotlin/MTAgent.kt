import jade.core.AID
import jade.core.Agent

class MTAgent : Agent() {
    override fun setup() {

        val name = name
        val number = arguments[0].toString().toInt()

        val connectedAgents = arguments[1].toString().split(".").map { x -> AID(x, false) }.toList()
        println("Name: $name\t Connected Agents: $connectedAgents")

        addBehaviour(MTAgentBehaviour(this, number, connectedAgents))
    }
}

