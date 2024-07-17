#Generics knowledge base app make file.
#Miguel Lavarinhas
#20 March 2024

JFLAGS = -g
JAVAC = javac
BIN = bin
FILES = \
		src/Statement.java \
		src/GenericsKbAVLApp.java \
		src/BinaryTreeNode.java \
		src/AVLTree.java \
		src/TestSubset.java

compile:
	$(JAVAC) $(JFLAGS) -d $(BIN) $(FILES)

clean:
	rm -f $(BIN)/*.class

run:
	java -cp $(BIN) GenericsKbAVLApp

