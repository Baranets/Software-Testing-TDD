# Software Testing TDD
Laboratory works for Software Testing. I will use the Swift and Java languages.

## Contents

- [Laboratory work №1](#laboratory-work-1)
  - [Description](#description-lab-1)
  - [Task](#task-lab-1)  
  - [Solution](#solution-lab-1)
- [Laboratory work №2](#laboratory-work-2)
  - [Description](#description-lab-2)
  - [Task](#task-lab-2)  
  - [Solution](#solution-lab-2)

<a name="laboratory-work-1"></a>
## Laboratory work №1 


<a name="description-lab-1"></a>
### Description 

1. For the specified function, conduct unit testing of the expansion of the function in a power series. Choose enough test coverage.
2. Conduct unit testing of this algorithm. To do this, select characteristic points within the algorithm, and for independently proposed sets of input data, write down the sequence of hits at characteristic points. Compare the hit sequence with the reference.
3. Generate a domain model for the given text. Develop test coverage for this domain model

<a name="task-lab-1"></a>
### Task (Variant 809)
- Sin (x) function
- Software module for sorting an array using the quick sort algorithm (<a name="http://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">http://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html</a>)
- Description of the subject area: 

> Однако ни в коем случае не было совпадением то, что сегодняшний день, день кульминации проекта, когда "Золотое Сердце" будет, наконец, представлен ошеломленной Галактике, был также великим днем кульминации Зафода Библброкса. Именно ради этого дня он когда-то принял решение баллотироваться в президенты. Решение, которое поразило и взволновало всю Галактическую Империю: как, Зафод Библброкс? Президентом? Тот самый Зафод Библброкс? Тем самым президентом? Многие видели в этом убедительное доказательство того, что все мироздание, в конце концов, сошло с ума.


<a name="solution-lab-1"></a>
### Solution

Click [hear](Test1)


<a name="laboratory-work-2"></a>
## Laboratory work №2 


<a name="description-lab-2"></a>
### Description 

- All the functions that make up the system (both trigonometric and logarithmic) must be expressed in terms of basic ones (trigonometric depends on the variant; logarithmic is the natural logarithm).
- The structure of the application tested in the laboratory should look like this (an example is given for the basic trigonometric function sin (x)):

![extention](https://se.ifmo.ru/documents/10180/262387/lab2.png/860963bf-d0e0-4d9c-bba0-2a151472ff57?t=1431462814367)

- Both "basic" functions (in the example above - sin (x) and ln (x)) should be implemented by expanding in a series with a given error. Using trigonometric / logarithmic transforms to simplify functions is FORBIDDEN.
- For each module, table plugs must be implemented. In this case, it is necessary to find the range of admissible values ​​of the functions, and, if necessary, determine the interdependent points in the modules.
- The developed application should allow the output of values ​​issued by any module of the system to a csv file of the form “X, Results of the module (X)”, allowing you to arbitrarily change the increment step X. You can use an arbitrary separator in the csv file.

<a name="task-lab-2"></a>
### Task (Variant 816)
![Task Image](https://github.com/Baranets/Software-Testing-TDD/blob/master/Test2/TaskImage.png?raw=true)

<a name="solution-lab-2"></a>
### Solution

Click [hear](Test2)
