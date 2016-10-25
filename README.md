
######Semester 2, 2016

## oose-company-training


### Summary 
The oose-company-training repo contains all the tex files for the report and any code used or created for the COMP2003 Assignment.

### Repository Structure
- *docs* - Assignment specification and other assignment relevant documents
- *report* - Files needed to build the report, written in LaTeX, also contains the current pdf of the report
- *src* - Source code required for particular tasks of the assignment. 

### Running the Program

From terminal, in the main project directory, with the build.xml file. 

- Compile and run the program
	- ``ant run`` 

- Remove all files created by compilation
	- ``ant clean``

- Compile all source code for the program
	- ``ant``

- To load different property, event and plan files place them in
	- ``resources/``	

- To alter the years of the simulation and to choose the files to run the program with. Alter the build.xml in the corresponding section below. Replace the sections in < > tags.

````xml
<target name="run" depends="jar">
    <java jar="${dist.dir}/${ant.project.name}.jar" fork="true">
        <arg value="${dist.dir}/<PROPERTYFILE>"/>
        <arg value="${dist.dir}/<EVENTFILE>"/>
        <arg value="${dist.dir}/<PLANFILE>"/>
        <arg value="<startYear>"/>
        <arg value="<endYear>"/>
    </java>
</target>
````