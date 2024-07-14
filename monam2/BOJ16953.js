const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [a, b] = input[0].split(' ').map(Number);
const queue = [];
let level = 0;

queue.push([a, level]);

while (queue.length > 0) {
    const [current, currentLevel] = queue.shift();
    
    if (current === b) {
        console.log(currentLevel + 1);
        return;
    }

    if (current * 2 <= b) {
        queue.push([current * 2, currentLevel + 1]);
    }
    if (current * 10 + 1 <= b) {
        queue.push([current * 10 + 1, currentLevel + 1]);
    }
}

console.log(-1);
