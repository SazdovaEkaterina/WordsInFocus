<template>
    <div class="container">
        <div class="row" v-for="(group, i) in groupLetters" v-bind:key="i">
                <router-link  class="letter" v-for="letter in letters.slice(i * itemsPerRow, (i + 1) * itemsPerRow)" :key="letter"
                    :to="{
                    name: 'Letter',
                    params: { l: letter },
                }">
                    {{letter}}
                </router-link>
        </div>
    </div>
</template>

<script>
    export default{
        name: "LettersComponent",
        data() {
            return {
                itemsPerRow: 8,
                letters : ["а", "б", "в", "г", "д", "ѓ", "е", "ж",
                "з", "ѕ", "и", "ј", "к", "л", "љ", "м", "н",
                "њ", "о", "п", "р", "с", "т", "ќ", "у",
                "ф", "х", "ц","ч", "џ","ш"],
                url: "/",
            
            }

        },
        methods:{
            async getLetters(){
               const lettersApi = await fetch('http://localhost:9090/api/letters')
               console.log(lettersApi) 
            }
        },
        computed: {
            groupLetters () {
                return Array.from(Array(Math.ceil(this.letters.length / this.itemsPerRow)).keys())
            },
        },
        beforeMount() {
            this.getLetters()
        },
    }
</script>

<style scoped>
.continer {
    height: 90vh;
    margin-bottom: 100px;
}
.row {
    width: 100%;
}
.letter {
    background-color: whitesmoke;
    display: inline-block;
    width: 80px;
    padding: 50px;
    margin: 10px 20px;
    font-size:xx-large;
    font-family: cursive;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    text-decoration: none;
} 
</style>