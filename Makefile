OBJ=Kierunek.class MainWindow.class PoleBitwy.class Punkt.class Robot.class SpanikowanyRobot.class Akcja.class Symulacja.class

all: $(OBJ)

%.class : %.java
	javac $<

clean:
	rm -f *.class *~

