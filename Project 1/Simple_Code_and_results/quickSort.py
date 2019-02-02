
import random
import timeit

def inPlaceQuickSort(array):
    inPlacePartition(array, 0, (len(array) - 1))


def inPlacePartition(array, start, stop):
    #print("In InPlacePartition",array)
    if stop - start > 0:
        left = start
        right = stop
        x = random.randint(start, stop)  # Randomly Choosing Pivot Everytime
        pivot = array[x]
        while left <= right:
            while array[left] < pivot:
                left += 1
            while array[right] > pivot:
                right -= 1
            if left <= right:
                temp = array[left]
                array[left] = array[right]
                array[right] = temp
                left += 1
                right -= 1
        inPlacePartition(array, start, right)
        inPlacePartition(array, left, stop)


if __name__ == '__main__':
    Time=[0]
    start = timeit.default_timer()
    arr = [3, 65, 55, 112, 90, 45, 0, 12, 6, 2, 99]
    arr1 = [7, 6, 5, 4, 3, 2, 1]
    arr2 = [1, 2, 3, 4, 5, 6, 7, 8, 99]
    print("Before Quick Sort ", arr2)
    inPlaceQuickSort(arr2)
    print("Sorted Output Using Quick Sort")
    print(arr2)
    stop = timeit.default_timer()
    Time.append((stop - start))
    print("Time Required :",Time[1])
