#Generics knowledge base app make file.
#Miguel Lavarinhas
#01 March 2024

JFLAGS = -g
JAVAC = javac
BIN = bin
FILES = \
		src/Statement.java \
		src/GenericsKbArrayApp.java \
		src/BinaryTreeNode.java \
		src/BinaryTree.java \
		src/GenericsKbBSTApp.java

compile:
	$(JAVAC) $(JFLAGS) -d $(BIN) $(FILES)

clean:
	rm -f $(BIN)/*.class

run1:
	java -cp $(BIN) GenericsKbArrayApp

run2:
	java -cp $(BIN) GenericsKbBSTApp
