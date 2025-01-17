#Generics knowledge base app make file.
#Miguel Lavarinhas
#01 March 2024

JFLAGS = -g
FILES = \
		src/Statement.java \
		src/GenericsKbArrayApp.java \
		src/BinaryTreeNode.java \
		src/BinaryTree.java \
		src/GenericsKbBSTApp.java

compile:
	javac GenericsKbArrayApp.java
	javac Statement.java
	javac GenericsKbBSTApp.java
	javac BinaryTreeNode.java
	javac BinaryTree.java

clean:
	rm /bin/*.class

run1:
	java GenericsKbArrayApp

run2:
	java GenericsKbBSTApp