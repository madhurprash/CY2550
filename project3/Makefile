JC = javac
JFLAGS = -g

.PHONY: default classes clean

default: classes

classes: xkcdpwgen.class

clean:
	@echo "Cleaning up..."
	@$(RM) xkcdpwgen.class

xkcdpwgen.class: xkcdpwgen.java
	$(JC) $(JFLAGS) xkcdpwgen.java

