#include <iostream> 
using namespace std;

int fibonachi(int seq)
{
    if(seq == 0)
    {
        return 0;
    } 
    else if(seq == 1 || seq == 2)
    {
        return 1;
    }

    return fibonachi(seq-1)+fibonachi(seq-2);
}

int main()
{
    int n;
    cin >> n;
    cout << fibonachi(n) << endl;
}