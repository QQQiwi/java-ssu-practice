Выбери объект из реального мира и реализуй его в виде класса (ООП). У него будут поля (хранимые состояния) и методы (регулирующие поведение объекта).

Класс реализует интерфейсы (прилагательные, которыми можно описать объект) и от него наследуются классы, расширяющие поведение объекта.

Пример

interface 2DFigure {getPerimeter(); getSquare();}

abstract class AbstractFigure {abstract String getNameOfFigure();}

class Line extends AbstractFigure implements 2DFigure
class Circle extends AbstractFigure implements 2DFigure
class Triangle extends AbstractFigure implements 2DFigure
class Rectangle extends AbstractFigure implements 2DFigure

В своем классе реализуй методы hashCode(), compareTo(), toString(), поверхностной и глубокой копии. Разберись, зачем они нужны.

Продемонстрируй работу полиморфизма на реализованных классах. В моем примере классы Line, Circle, Rectangle, Triangle должны реализовать методы getPerimeter() и getSquare() для подсчета периметра и площади соответственно.