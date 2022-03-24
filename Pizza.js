const amasar = async (minutos) => {
    return new Promise(resolve => setTimeout(() => {
        resolve('Listo, amasamos!')
    }, minutos *1000));
}

const cocinarPizza = async (minutos) => {
    return new Promise(resolve => setTimeout(() => {
        resolve('Beep! Pizza lista!')
    }, minutos * 1000));
}

const reposo = async (minutos) => {
    return new Promise(resolve => setTimeout(() => {
        resolve('Listo')
    }, minutos * 1000));
}

const comerPizza = async () => {
    console.log('Preparamos la masa en 3, 2, 1..')
    console.log(await amasar(3))
    console.log("Cocinamos la pizza")
    console.log(await cocinarPizza(10))
    console.log("sacar pizza")
    console.log("Dejamos reposar la pizza 20 segundos")
    console.log(await reposo(20))
    console.log("A comer!!")
}

comerPizza()