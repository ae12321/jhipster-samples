import { Greeter } from './modules/greeter';

async function main() {
  const greeter = new Greeter('abc');
  console.log(await greeter.sayHelloAsync());
  console.log(greeter.sayHello());
  console.log(await greeter.sayHelloAsync(4));
}
main();
