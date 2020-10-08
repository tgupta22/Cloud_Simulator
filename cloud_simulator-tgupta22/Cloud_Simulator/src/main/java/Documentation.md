****CS 441: Engineering Distributed Objects for Cloud Computing**


**Description:
To Create cloud simulators for evaluating executions of applications in cloud datacenters with different characteristics and deployment models.**

**Author: Tarush Gupta**

**Instructions on how to install and run My Cloud Simulator**

**Development Environment Used:**


**1) IDE:** Intellij Idea Ultimate 2020.2.1
**2) Gradle Version:** "6.6.1
**3)Kotlin:** 1.3.72
**4)Groovy:** 2.5.12
**5)Ant:** Apache Ant(TM) version 1.10.8 compiled on May 10 2020
**6)JVM:** 1.8.0_251 (Oracle Corporation 25.251-b08)
**7)OS:** Windows 10 10.0 amd64

**Dependencies and Assembly Details:**

1) Added Clousim dependcy from https://github.com/manoelcampos/cloudsim-plus, to access the cloudsim project files.

2) Added type Config dependency to access Config object.

3) Added build.gradle file to the Cloud_Simulator as External Libraries Project to run and build the java project in the Intellij IDE.

4) Added JUnit Test Module to build and run JUnit Test Cases for the program.

**How to Run the Cloud-Simulator**

1) Install the latest version of Intellij, then open the project on Intellij.

2) Look up to the Project Structure -> Modules in Intellij and then add Cloud_Simulator as the Gradle Project.

3) Before executing any commands, look up to Cloud_Simulator:

4) Finally execute  > gradle clean build test ->  gradle clean build run
                    

**Aim of the Project:**

In this Project I mainly focused on developing a Cloud Simulator by using CloudSim Plus as a reference structure and implement Cloud Computing infrastructures and services.

**What I learned:**

1) I learned how add and incorporate different dependencies and libraries required to setup the basic structure of the project.
2) How to use config libraries to input the values rather than hardcoding them.
3) I learned how to implement, use and understand the workings of different Cloud Simulation poilices.
4) How logging works and how to implement to check our workings.
5) I gained experience in executing multiple simulations with different parameters, statistically analyzed the results.
6) Learned and reported the results in a structured documentation with explanations why some cloud architectures are more efficient than the others in the simulations.


**In the Cloud_Simulator project there are 8 folders/components:**

**1) .gradle :** A .gradle file is a script created by Gradle, which is a tool used to help teams build and deliver software
**2) .idea :**  The .idea directory contains a set of configuration files (. xml) for the project. These configuration files contain information core to the project itself, such as names and locations of its component modules, compiler settings, etc.
**3) build :** A build file is used to automate many of the steps involved in software development (ie. automated compiling). As your software becomes more complex, build files allows us  to establish a standard way of building your program. 
**4) gradle:**  GRADLE files are typically used for storing build scripts in a domain-specific language based on Groovy.                    
**5) src:** Src folder is where the complete code of the program is stored.
**6) target:** Target file extension usually contain development files. 
**7) Gradle Project files:** In this project it consists of build.gradle, gradlew, gradlew.bat, settings.gradle.
**8) External Libraries:** Consists of libraries used for the project, in this project it is particullarly gradle and cloudsim.

**Code Structure for Src folder:**

In the Src folder there are two sub-folders main and test.
The main folder consists of two folders under the java folder (hw_441 and Mapper_Reducer) along with a Readme.md file that consits of the documentation for the program.
The other folder in the main folder is the resources folder that consists of (Application.conf and Appliction2.conf) that allows us to use the Config Library.
It also consits of a Topology.brite file that consits of edge switches and the node structure of the simulation.

**Code structure  for hw_441-> Sub folders/file folder:**

=> In both app_config and app_config2 I have created functions that could be accessed in the files hw1 and hw2. The values are being 
fetched from Application.conf and Application2.conf files respectively. Support and Support2 files are the ones that help connect the 
config library and config simulator to be acceseed in app_config and app_config2 respectively. 

=> The app_constants is another files that can be used to declare and access the values that could be used in hw1 files instead of hard coding it. 

=> The Cost files declares the cost and time structure for different tasks in the simulation to execute. 
Such as time zone this resource located, the cost of using processing in this resource, the cost of using memory in this resource, the cost of using storage in this resource.

=> Mapper_Reducer folder consits of:

Mapper: That mainly extends the NetworkCLoudlet and works with CloudLength and PES.
Reducer: Consits of same entites as mapper but corresponsds to the working of the reducer in the Mapper_Reducer implementation.
Helper: Helper is the helper for Mapper_Reducer implementation.
Execute: Consits of the major working parts for the implementation.

**NOTE:** 
I have two hw, config and support files as I was trying to implement different utilization models and policies and 
was able to test them simultaenously. 

Test folder consists of 8 JUnit Test Cases that check the working of different aspects of the Cloud Simulator. 

**VM Allocation Policies Used for Statistical Analyses:**

**1) VmAllocationPolicySimple:** A VmAllocationPolicy implementation that chooses, as he host for a VM, that one with the fewest PEs in use.
    It is therefore a Worst Fit policy, allocating each VM into the host with most available PEs.  
    
**2) VmAllocationPolicyBestFit:** A Worst Fit VmAllocationPolicy implementation that chooses, as the host for a VM, that one with the most number of PEs in use,
                                   which are enough for a VM.
                                  
**3) VmAllocationPolicyFirstFit:** A Policy which finds the first Host having suitable resources to place a given VM. his is a high time-efficient policy with a best-case complexity O(1)  
 
 **Cloudlet Utilizations Used** 
 
 **UtilizationModelStochastic:** Implements a model, according to which a Cloudlet generates random resource utilization every time frame.   
 **UtilizationModelFull:** In this type of model a Cloudlet always utilizes a given allocated resource from its Vm at 100%, all the time.   
                                                                                    


** Below are the Statistical results for the VmAllocationPolicySimple along with full utilization model.**

                                         SIMULATION RESULTS

Cloudlet|Status |DC|Host|Host PEs |VM|VM PEs   |CloudletLen|CloudletPEs|StartTime|FinishTime|ExecTime
      ID|       |ID|  ID|CPU cores|ID|CPU cores|         MI|  CPU cores|  Seconds|   Seconds| Seconds
-----------------------------------------------------------------------------------------------------
       0|SUCCESS| 1|   0|       15| 0|        1|      10000|          1|       12|        15|       3
       1|SUCCESS| 1|   1|       15| 1|        1|      10000|          1|       12|        15|       3
       2|SUCCESS| 1|   2|       15| 2|        1|      10000|          1|       12|        15|       3
       3|SUCCESS| 1|   3|       15| 3|        1|      10000|          1|       12|        15|       3
       4|SUCCESS| 1|   4|       15| 4|        1|      10000|          1|       12|        15|       3
       5|SUCCESS| 1|   5|       15| 5|        1|      10000|          1|       12|        15|       3
       6|SUCCESS| 1|   6|       15| 6|        1|      10000|          1|       12|        15|       3
       7|SUCCESS| 1|   7|       15| 7|        1|      10000|          1|       12|        15|       3
       8|SUCCESS| 1|   8|       15| 8|        1|      10000|          1|       12|        15|       3
       9|SUCCESS| 1|   9|       15| 9|        1|      10000|          1|       12|        15|       3
      10|SUCCESS| 1|  10|       15|10|        1|      10000|          1|       12|        15|       3
      11|SUCCESS| 1|  11|       15|11|        1|      10000|          1|       12|        15|       3
      12|SUCCESS| 1|  12|       15|12|        1|      10000|          1|       12|        15|       3
      13|SUCCESS| 1|  13|       15|13|        1|      10000|          1|       12|        15|       3
      14|SUCCESS| 1|  14|       15|14|        1|      10000|          1|       12|        15|       3
-----------------------------------------------------------------------------------------------------

** Below are the Statistical results for the VmAllocationPolicySimple along with Stochastic utilization model.**

                                        SIMULATION RESULTS

Cloudlet|Status |DC|Host|Host PEs |VM|VM PEs   |CloudletLen|CloudletPEs|StartTime|FinishTime|ExecTime
      ID|       |ID|  ID|CPU cores|ID|CPU cores|         MI|  CPU cores|  Seconds|   Seconds| Seconds
-----------------------------------------------------------------------------------------------------
       0|SUCCESS| 1|   0|       15| 0|        1|      10000|          1|       12|        33|      21
       1|SUCCESS| 1|   1|       15| 1|        1|      10000|          1|       12|        33|      21
       2|SUCCESS| 1|   2|       15| 2|        1|      10000|          1|       12|        33|      21
       3|SUCCESS| 1|   3|       15| 3|        1|      10000|          1|       12|        33|      21
       4|SUCCESS| 1|   4|       15| 4|        1|      10000|          1|       12|        33|      21
       5|SUCCESS| 1|   5|       15| 5|        1|      10000|          1|       12|        33|      21
       6|SUCCESS| 1|   6|       15| 6|        1|      10000|          1|       12|        33|      21
       7|SUCCESS| 1|   7|       15| 7|        1|      10000|          1|       12|        33|      21
       8|SUCCESS| 1|   8|       15| 8|        1|      10000|          1|       12|        33|      21
       9|SUCCESS| 1|   9|       15| 9|        1|      10000|          1|       12|        33|      21
      10|SUCCESS| 1|  10|       15|10|        1|      10000|          1|       12|        33|      21
      11|SUCCESS| 1|  11|       15|11|        1|      10000|          1|       12|        33|      21
      12|SUCCESS| 1|  12|       15|12|        1|      10000|          1|       12|        33|      21
      13|SUCCESS| 1|  13|       15|13|        1|      10000|          1|       12|        33|      21
      14|SUCCESS| 1|  14|       15|14|        1|      10000|          1|       12|        33|      21
-----------------------------------------------------------------------------------------------------

** Below are the Statistical results for the VmAllocationPolicyBestFit along with Stochastic utilization model.**

                                         SIMULATION RESULTS

Cloudlet|Status |DC|Host|Host PEs |VM|VM PEs   |CloudletLen|CloudletPEs|StartTime|FinishTime|ExecTime
      ID|       |ID|  ID|CPU cores|ID|CPU cores|         MI|  CPU cores|  Seconds|   Seconds| Seconds
-----------------------------------------------------------------------------------------------------
       0|SUCCESS| 1|   0|       15| 0|        1|      10000|          1|       12|        16|       4
       1|SUCCESS| 1|   1|       15| 1|        1|      10000|          1|       12|        16|       4
       2|SUCCESS| 1|   2|       15| 2|        1|      10000|          1|       12|        16|       4
       3|SUCCESS| 1|   3|       15| 3|        1|      10000|          1|       12|        16|       4
       4|SUCCESS| 1|   4|       15| 4|        1|      10000|          1|       12|        16|       4
       5|SUCCESS| 1|   5|       15| 5|        1|      10000|          1|       12|        16|       4
       6|SUCCESS| 1|   6|       15| 6|        1|      10000|          1|       12|        16|       4
       7|SUCCESS| 1|   7|       15| 7|        1|      10000|          1|       12|        16|       4
       8|SUCCESS| 1|   8|       15| 8|        1|      10000|          1|       12|        16|       4
       9|SUCCESS| 1|   9|       15| 9|        1|      10000|          1|       12|        16|       4
      10|SUCCESS| 1|  10|       15|10|        1|      10000|          1|       12|        16|       4
      11|SUCCESS| 1|  11|       15|11|        1|      10000|          1|       12|        16|       4
      12|SUCCESS| 1|  12|       15|12|        1|      10000|          1|       12|        16|       4
      13|SUCCESS| 1|  13|       15|13|        1|      10000|          1|       12|        16|       4
      14|SUCCESS| 1|  14|       15|14|        1|      10000|          1|       12|        16|       4
-----------------------------------------------------------------------------------------------------

** Below are the Statistical results for the VmAllocationPolicyBestFit along with full utilization model.**

                                         SIMULATION RESULTS

Cloudlet|Status |DC|Host|Host PEs |VM|VM PEs   |CloudletLen|CloudletPEs|StartTime|FinishTime|ExecTime
      ID|       |ID|  ID|CPU cores|ID|CPU cores|         MI|  CPU cores|  Seconds|   Seconds| Seconds
-----------------------------------------------------------------------------------------------------
       0|SUCCESS| 1|   0|       15| 0|        1|      10000|          1|       12|        15|       3
       1|SUCCESS| 1|   1|       15| 1|        1|      10000|          1|       12|        15|       3
       2|SUCCESS| 1|   2|       15| 2|        1|      10000|          1|       12|        15|       3
       3|SUCCESS| 1|   3|       15| 3|        1|      10000|          1|       12|        15|       3
       4|SUCCESS| 1|   4|       15| 4|        1|      10000|          1|       12|        15|       3
       5|SUCCESS| 1|   5|       15| 5|        1|      10000|          1|       12|        15|       3
       6|SUCCESS| 1|   6|       15| 6|        1|      10000|          1|       12|        15|       3
       7|SUCCESS| 1|   7|       15| 7|        1|      10000|          1|       12|        15|       3
       8|SUCCESS| 1|   8|       15| 8|        1|      10000|          1|       12|        15|       3
       9|SUCCESS| 1|   9|       15| 9|        1|      10000|          1|       12|        15|       3
      10|SUCCESS| 1|  10|       15|10|        1|      10000|          1|       12|        15|       3
      11|SUCCESS| 1|  11|       15|11|        1|      10000|          1|       12|        15|       3
      12|SUCCESS| 1|  12|       15|12|        1|      10000|          1|       12|        15|       3
      13|SUCCESS| 1|  13|       15|13|        1|      10000|          1|       12|        15|       3
      14|SUCCESS| 1|  14|       15|14|        1|      10000|          1|       12|        15|       3
-----------------------------------------------------------------------------------------------------
**Discussion:**

=> In the first simulation results  we ran the VmAllocationPolicySimple along with full utilization model and in the second simulation results we ran 
the Statistical results for the VmAllocationPolicySimple along with Stochastic utilization model.
The difference is evident in both the finish and execution time of both the simulations.

=> If we use the different allocation policy but the similar utlization model it is hard to see any different results. But when we use different utilization model's
in our simulation we can certainly see difference in the finish and exec time.  

=> Above we can clearly see Simulation results 1 and 4 are identical even though we use different policies but with the same utilization model,
i.e, full utilization which gives us the same results as compared to a stochastic model that gives randomized result.

                                
                                   
                                   
           

     




