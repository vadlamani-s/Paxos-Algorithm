# Paxos-Algorithm
The aim of the project is to implement the Paxos algorithm. Although, it ensured consistency across replicas, it was prone to failures and was not fault tolerant. To make sure the data is consistent across all the replicas, the paxos algorithm is implemented. The current project is the continuation of project where the RPC was implemented across the servers and client. When a request is placed to server from the client, the prepare phase is initiated first and the current server is elected to be the leader. During this phase, a promise is sent to all the servers (each of the promise carry an ID). The server accepts a promise if it has not accepted any promise previously and if it did accept one already, if the current proposed ID is greater, then the server chooses to accept the higher promise. Promises with smaller ID are ignored. Once the leader gets maximum acceptances, the accept phase is initiated. During this phase, the value along with the promise is passed to all the servers. Once all the servers come to consensus about the value, does not have to be the promise ID because the prepare phase takes care of this, the learners are issued a notification to perform the operation. For the current project I have included random failure during the accept phase and the piggy backing of values is also considered.

# Steps to run
Run the following commands from the project folder in a terminal.

For Maven below are the steps:

1 a. The Server.java file has to be run in the following format.
mvn -DskipTests package exec:java -Dexec.mainClass=Server.Server -Dexec.args="current portNo|ServerName|port2|port3|port4|port5"

The following arguments can be used for running each server
5001|Server1,5002|5003|5004|5005
5002|Server2,5001|5003|5004|5005
5003|Server3,5001|5002|5004|5005
5004|Server4,5001|5002|5003|5005
5005|Server5,5001|5002|5003|5004

Note: The portNo and ServerName have be changed for every instance of Server.

1 b. The Client.java file has to be in the following format:
mvn -DskipTests package exec:java -Dexec.mainClass=Client.Client -Dexec.args='portNo|ClientName'
Example:
5001|Client1

Alternate Method to run:
The project can be run directly in Intellij by creating multiple applications with the above mentioned arguments.


Note: The portNo and ClientName have be changed for every instance of Client. The port number for the 
client should be same as one of the server instance.

Input to Dictionary:
Key - Integer
Value - String (string to be entered without any space)
PUT operation: put <key> <value>
GET operation: get <key>
DELETE operation: delete <key>


Initially the required demo operations would be run. These include the 15 random operations as mentioned in the requirement.
Each of the operation has a wait period of 6 seconds. The project is programmed to include random server failures during accept phase.

Exit the client:
The server has to be force terminated but the "exit" can be used for terminating the client. 
