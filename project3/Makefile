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

run: xkcdpwgen.class
	@java xkcdpwgen






# JC = javac
# JFLAGS = -g
# .SUFFIXES: .java .class

# SOURCES := $(wildcard *.java)  
# CLASSES := $(SOURCES:.java=)  

# .PHONY: default classes clean

# default: classes

# classes: $(CLASSES)

# %: %.java
# 	@echo "Building classes $<..."
# 	$(JC) $(JFLAGS) $<

# clean:
# 	@echo "Cleaning up..."
# 	@$(RM) $(CLASSES)

