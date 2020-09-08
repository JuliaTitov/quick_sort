/*Быстрая сортировка: выбираем опорный элемент, все элементы большие или равные ему перемещаем вправо от опорного, 
 * все меньшие - влево от опорного. Повторяем процедуру с каждым подмассивом. Реализация: выбираем опорным последний элемент в массиве, проверяем 
 * с начала массива, ищем элементы больше опорного и перемещаем вправо. При этом на место перемещаемого ставим элемент, который находился перед опорным
 * а опорный сдвигаем влево на одну позицию. Рекурсивно повторяем для каждого подмассива, после того, как опорный окажетс на своем месте.*/
public class Lesson52_quickSort {

	public static void main(String[] args) {
		int [] array = new int [10];
		fill(array);
		print(array);
		sort(array, 0, array.length - 1);
		print(array);
	}
	public static void fill(int [] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100);
		}
	}
	public static void print(int [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "]" + " = " + array[i]);
		}
		System.out.println();
	}
	public static void sort(int [] array, int indexStart, int indexEnd) {
		if (indexStart >= indexEnd) {
			return;
		}
		int basicIndex = indexEnd;
		int i = indexStart; 
		while (i != basicIndex) {
			if ((array[i] >= array[basicIndex])) {
				int help = array[i];
				array[i] = array[basicIndex - 1];
				array[basicIndex - 1] = array[basicIndex];
				array[basicIndex] = help;
				basicIndex--;
			}
			else 
				i++;
		}
		sort(array, indexStart, basicIndex - 1);
		sort(array, basicIndex + 1, indexEnd);
	}
}