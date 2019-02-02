import random
import timeit

def merge_sort(S):
    if len(S) <= 1:
        return S
    left=[]
    right = []
    middle = int(len(S) / 2)
    #print(middle)
    for i in range(0,middle):
        left.append(S[i])
    for i in range(middle,len(S)):
        right.append(S[i])
    #right = S[middle:]
    left = merge_sort(left)
    right = merge_sort(right)
    return list(merge(left, right))


def merge(left, right):
    result = []
    left_index, right_index = 0, 0
    while left_index < len(left) and right_index < len(right):
        if left[left_index] <= right[right_index]:
            result.append(left[left_index])
            left_index += 1
        else:
            result.append(right[right_index])
            right_index += 1
    while left_index<len(left):
        result.append(left[left_index])
        left_index +=1

    while right_index<len(right):
        result.append(right[right_index])
        right_index +=1

    return result

if __name__ == '__main__':
    Time = [0]
    start = timeit.default_timer()
    arr = [3, 65, 55, 112, 90, 45, 0, 12, 6, 2, 99]
    arr1 = [7, 6, 5, 4, 3, 2, 1]
    arr2 = [1, 2, 3, 4, 5, 6, 7, 8, 99]
    print("Before Merge Sort ", arr2)
    x = merge_sort(arr2)
    print("Sorted Output Using Merge Sort")
    print(x)
    stop = timeit.default_timer()
    Time.append((stop - start))
    print("Time Required :",Time[1])
