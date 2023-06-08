JC = javac
JFLAGS = -g

.SUFFIXES: .java .class
.java.class:
    $(JC) $(JFLAGS) -cp . $*.java

CLASSES = \
    xkcdpwgen.java

default: classes xkcdpwgen

classes: $(CLASSES:.java=.class)

clean:
    $(RM) *.class
