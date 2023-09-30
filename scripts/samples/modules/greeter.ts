export class Greeter {
  private name: string;
  constructor(name: string) {
    this.name = name;
  }
  sayHello() {
    return `hello, ${this.name}`;
  }
  sayHelloAsync(sec = 2) {
    return new Promise(resolve => {
      setTimeout(() => {
        return resolve(`hello, ${this.name} after ${sec}sec`);
      }, sec * 1000);
    });
  }
}
