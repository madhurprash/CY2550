JC = javac
JFLAGS = -g
.SUFFIXES: .java .class

SOURCES := $(wildcard *.java)  
CLASSES := $(SOURCES:.java=)  

.PHONY: default classes clean

default: classes

classes: $(CLASSES)

%: %.java
	@echo "Building classes $<..."
	$(JC) $(JFLAGS) $<

clean:
	@echo "Cleaning up..."
	@$(RM) $(CLASSES)


# JC = javac
# JFLAGS = -g
# .SUFFIXES: .java .class

# .java.class:
# 	$(JC) $(JFLAGS) $*.java

# CLASSES = xkcdpwgen

# default: classes

# classes: $(CLASSES)


# clean:
#     @echo "cleaning up ..."
# 	$(RM) *.class

