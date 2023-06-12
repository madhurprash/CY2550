JC = javac
JFLAGS = -g
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = xkcdpwgen

default: classes

classes: $(CLASSES:=.class)

clean:
	$(RM) *.class

