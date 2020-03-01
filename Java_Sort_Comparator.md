Classic comparator
```java
	Comparator<Developer> byName = new Comparator<Developer>() {
		@Override
		public int compare(Developer o1, Developer o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
```

Java 8 Lambda expression
```java
	Comparator<Developer> byName = 
		(Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
```
https://mkyong.com/java8/java-8-lambda-comparator-example/


ex. #973 K-closest Points to Origin

```java
public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    return Arrays.copyOfRange(points, 0, K);
}
```
