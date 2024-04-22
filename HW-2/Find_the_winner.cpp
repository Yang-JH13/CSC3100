#include <iostream>
#include <vector>
using namespace std;

int winner_label(vector<int> sum_row, vector<int> sum_column) {
    int n = sum_row.size();
    for (int i = 0; i < n; i++) {
        if (sum_column[i] == n - 1 && sum_row[i] == 0) {
            return i;
        }
    }
    return -1;
}

int main() {
    int n,k;
    cin >> n;
    vector<int> sum_column(n);
    vector<int> sum_row(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> k;
            sum_row[i] = k + sum_row[i];
            sum_column[j] = k + sum_column[j];
        }
    }
    int winner = winner_label(sum_row, sum_column);
    cout << winner;
    return 0;
}