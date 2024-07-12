const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const grid = input.slice(1).map(line => line.split(" ").map(Number));

const directions = [
    [-1, 1],
    [0, 1],
    [1, 1]
];

const INF = Number.MAX_SAFE_INTEGER;

let dp = Array.from({ length: N }, () => Array.from({ length: M }, () => Array(3).fill(INF)));

// 첫 번째 행
for (let j = 0; j < M; j++) {
    dp[0][j][0] = grid[0][j];
    dp[0][j][1] = grid[0][j];
    dp[0][j][2] = grid[0][j];
}

for (let i = 1; i < N; i++) {
    for (let j = 0; j < M; j++) {
        for (let k = 0; k < 3; k++) {
            const [dx, dy] = directions[k];
            const prevRow = i - 1;
            const prevCol = j + dx;

            if (prevCol >= 0 && prevCol < M) {
                for (let l = 0; l < 3; l++) {
                    if (l !== k) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[prevRow][prevCol][l] + grid[i][j]);
                    }
                }
            }
        }
    }
}

let minFuel = INF;
for (let j = 0; j < M; j++) {
    for (let k = 0; k < 3; k++) {
        minFuel = Math.min(minFuel, dp[N - 1][j][k]);
    }
}

console.log(minFuel);
