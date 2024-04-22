#include <iostream>
#include <vector>

using namespace std;

#define ll long long
#define mod 1000000007
const int N = 2e5 + 5;
vector<pair<int, int>> g[N];
int color[N];
ll sz[N], dp[N], ans[N];

void dfs1(int u, int fa) {
    sz[u] = color[u];
    for (auto it : g[u]) {
        int v = it.first, w = it.second;
        if (v == fa) continue;
        dfs1(v, u);
        sz[u] += sz[v];
        dp[u] = (dp[u] + dp[v] + sz[v] * w) % mod;
    }
}

void dfs2(int u, int fa) {
    ans[u] = dp[u];
    for (auto it : g[u]) {
        int v = it.first, w = it.second;
        if (v == fa) continue;
        dp[u] = ((dp[u] - dp[v] - sz[v] * w) % mod + mod) % mod;
        sz[u] -= sz[v];
        dp[v] = (dp[v] + dp[u] + sz[u] * w) % mod;
        sz[v] += sz[u];
        dfs2(v, u);
        sz[v] -= sz[u];
        dp[v] = ((dp[v] - dp[u] - sz[u] * w) % mod + mod) % mod;
        sz[u] += sz[v];
        dp[u] = (dp[u] + dp[v] + sz[v] * w) % mod;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> color[i];

    for (int i = 1; i < n; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }

    dfs1(1, 0);
    dfs2(1, 0);

    for (int i = 1; i <= n; i++) cout << ans[i] << '\n';

    return 0;
}