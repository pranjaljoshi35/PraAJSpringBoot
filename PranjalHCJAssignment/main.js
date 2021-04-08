const container = document.getElementById('flex-table')
const form = document.querySelector("form")
let name = ""
let email = ""
let web = ""
let image = ""
let gender = ""
const button = document.getElementById('submit')

form.addEventListener('submit' , function(event){
    event.preventDefault()
    name = form.elements[0].value
    email = form.elements[1].value
    web = form.elements[2].value
    image = form.elements[3].value
    const leftDiv = document.createElement('div')
    leftDiv.classList.add('inner-table')
    leftDiv.innerHTML =  `
        <h3>${name}</h3>
        <h5>${email}</h5>
        <a href=${web}>${web}</a>
    `
    container.append(leftDiv)

    const rightDiv = document.createElement('div')
    rightDiv.classList.add('inner-table')
    rightDiv.classList.add('right-img-div')
    rightDiv.innerHTML =  `<img src = ${image} />`
    container.append(rightDiv)
})
