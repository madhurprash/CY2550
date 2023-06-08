JC = javac
JFLAGS = -g

.SUFFIXES: .java .class
.java.class:
    $(JC) $(JFLAGS) -cp . $*.java

CLASSES = \
    xkcdpwgen.java

default: classes

classes: $(CLASSES)

clean:
    $(RM) *.class
