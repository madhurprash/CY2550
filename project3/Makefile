JC = javac
JFLAGS = -g

.PHONY: default classes clean force

default: classes

classes: force
	$(JC) $(JFLAGS) xkcdpwgen.java

clean:
	@echo "Cleaning up..."
	@$(RM) xkcdpwgen.class

force: ;
