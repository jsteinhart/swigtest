MODULE = tester
WRAPPER   = $(MODULE)_wrap.cpp
INTERFACE = $(MODULE).i
DESTDIR = generated


SWIG = swig3.0
SWIGOPT = -c++ -java
JAVAINC = -I/usr/lib/jvm/java-7-oracle/include -I/usr/lib/jvm/java-7-oracle/include/linux
PROJINC = -Isrc/main/include
CXXINC = $(JAVAINC) $(PROJINC)
CXXFLAGS = -fPIC $(PROJINC) $(JAVAINC)

.PHONY = clean dir

VPATH = src/main/swig:src/main/include:src/main/c++

all: libtester.so

libtester.so : $(DESTDIR)/Tester.o $(DESTDIR)/$(MODULE)_wrap.o | $(DESTDIR)
	$(LINK.cc) -shared $^ -o $@
	

$(DESTDIR):
	mkdir $@


$(DESTDIR)/%.o: %.cpp | $(DESTDIR)
	$(COMPILE.cpp) -o $@ $<



$(DESTDIR)/$(WRAPPER): $(INTERFACE) | $(DESTDIR)
	$(SWIG) $(SWIGOPT) $(PROJINC) -o $@ $<
	
clean:
	rm -rf $(DESTDIR)
	rm -f libtester.so