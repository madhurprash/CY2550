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

