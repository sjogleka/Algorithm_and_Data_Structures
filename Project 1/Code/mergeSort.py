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
    n = [500, 1000, 2000, 4000, 5000, 10000, 20000, 30000, 40000, 50000]
    for j in range(0, 10):
        start = timeit.default_timer()
        arr = []
        for i in range(n[j]):
            arr.append(random.randint(1, n[j]))
        print("########################## For n = ", n[j], "############################")
        print("Before Merge Sort ", arr)
        x = merge_sort(arr)
        print("Sorted Output Using Merge Sort")
        print(x)
        #print(len(arr),len(x))
        stop = timeit.default_timer()
        Time.append((stop - start))
        print("Time Required :",Time[j+1])
