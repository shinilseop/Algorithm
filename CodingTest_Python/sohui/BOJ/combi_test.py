def combination(arr, r):
    # 1.
    arr = sorted(arr)

    # 2.
    def generate(chosen):
        if len(chosen) == r:
            print(chosen)
            return

        # 3.
        start = arr.index(arr[chosen[-1]]) + 1 if chosen else 0
        for nxt in range(start, len(arr)):
            chosen.append(nxt)
            generate(chosen)
            chosen.pop()

    generate([])


combination('ABCDE', 2)
combination([1, 2, 3, 4, 5], 3)
